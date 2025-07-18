package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.controller.update.MouseController;
import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.gui.painters.*;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.VezaElement;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

@Getter
@Setter
public class MapTab extends JPanel implements UpdateListener, ISubscriber, IPublisher {

        private MapView mapView;

        private List<Element> selectedElements;

        private AffineTransform affineTransform;

        private double scale;
        private double transX;
        private double transY;

        private List<ISubscriber> subscribers;

        private SelectPainter selectPainter;




    public MapTab(MindMap selected) {
        mapView=new MapView(selected);
        selectedElements = new ArrayList<>();
        affineTransform = new AffineTransform();
        subscribers = new ArrayList<>();
        scale = 1;
        transX = 0;
        transY = 0;
        selectPainter=null;


        MouseController mouseController = new MouseController();


        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);

        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
        mapView.getMindMap().addSubscriber(this);
        update(mapView);
        notifySubscriber(this);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke=new BasicStroke(5F);
        g2.setStroke(stroke);
        g2.scale(scale,scale);

        g2.translate(transX,transY);

        List<PojamPainter> pojamPainters=new ArrayList<>();

            for(ElementPainter elementPainter : mapView.getPainters()){
                if(elementPainter instanceof VezaPainter){
                    elementPainter.paint(g2,elementPainter.getElement());
                }else if(elementPainter instanceof PojamPainter){
                    pojamPainters.add((PojamPainter) elementPainter);
                }

            }
            for(PojamPainter pp:pojamPainters){
                pp.paint(g2,pp.getElement());
            }

            if(selectPainter!=null)
               selectPainter.paint(g2, scale, transX, transY);
        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        subscribers.clear();
        for(MapNode subscriber: mapView.getMindMap().getChildren()){
            addSubscriber((ISubscriber) subscriber);
        }
        repaint();
    }


    public void updateSelected(String name, Stroke stroke,Paint paint){
        for(Element e: selectedElements){
            if(e instanceof PojamElement){

                e.setName(name);
                e.setStroke(stroke);
                e.setPaint(paint);
            }
        }
        mapView.updateList();
        updatePerformed(new UpdateEvent(this));
    }

    public void addSelectedElement(Point x) {


        x.translate((int) (-transX*scale), (int) (-transY*scale));

        Element element = mapView.getMindMap().getChildOnLocation(x);

        if(element instanceof PojamElement){
            ((PojamElement)element).setSelected(true);
            selectedElements.add(element);
        }
    }

    public void addPainter(ElementPainter elementPainter){
        elementPainter.getElement().setParent(mapView.getMindMap());
        mapView.addPainter(elementPainter);
        updatePerformed(new UpdateEvent(this));
    }


    public void removePainter(Point x){

        x.translate((int) (-transX*scale), (int) (-transY*scale));

        mapView.removeChild(x);
        if(!mapView.containsElementOnPoint(x))selectedElements.remove(mapView.getMindMap().getChildOnLocation(x));
        updatePerformed(new UpdateEvent(this));
    }
    public void removePainter(Element element){

        mapView.removeChild(element);
        if(!selectedElements.contains(element))selectedElements.remove(element);
        updatePerformed(new UpdateEvent(this));
    }

    public void addSelection(Element e){
        ((PojamElement)e).setSelected(true);
        if(!selectedElements.contains(e))selectedElements.add(e);
    }


    public void addVeza(Point x, Point y) {


        x.translate((int) (-transX*scale), (int) (-transY*scale));
        y.translate((int) (-transX*scale), (int) (-transY*scale));

        mapView.addPainter(x,y);
        updatePerformed(new UpdateEvent(this));
    }

    @Override
    public void update(Object notification) {
        mapView.updateList();
        updatePerformed(new UpdateEvent(this));
    }

    public ElementPainter getPainter(Element element){
        return mapView.getPainter(element);
    }

    public void drawMyLine(Point a, Point b) {
        Graphics2D g2 = (Graphics2D) getGraphics();
        BasicStroke stroke=new BasicStroke(2F);
        if(a == null || b==null) return;
        Shape shape = new Line2D.Double(a,b);
        g2.setStroke(stroke);
        g2.setPaint(Color.BLACK);
        g2.draw(shape);
        g2.fill(shape);


    }

    public void moveSelected(double h, double w) {
        if(selectedElements.size() == 0) moveView(h,w);
        h/=scale;
        w/=scale;
        for(Element e:selectedElements){
            if(e instanceof PojamElement){
                ((PojamElement) e).movePoint( h, w);
            }
        }
        mapView.updateList();
        updatePerformed(new UpdateEvent(this));
    }

    public void moveView(double x, double y) {
        transX+=x/scale;
        transY+=y/scale;
        notifySubscriber(this);
        update(this);
    }


    public  void zoomIn(){
        scale*=2;
        notifySubscriber(this);
        affineTransform.scale(scale,scale);
        update(this);
    }
    public  void zoomOut(){
        scale/=2;
        notifySubscriber(this);
        affineTransform.scale(scale,scale);
        update(this);
    }

    public void centrirajPojam(Point x){
        Element pojamElement = mapView.getMindMap().getChildOnLocation(x);
        if(pojamElement==null)mapView.resetCenter();
        if(pojamElement instanceof PojamElement){
            double x1 = 25;
            double y1 = 25;
            x1/=scale;
            y1/=scale;
            ((PojamElement) pojamElement).setPosition(new Point((int) x1, (int) y1));
            mapView.resetCenter();
            ((PojamElement) pojamElement).setCentered(true);

            Map<PojamElement,Integer> korisceni = new HashMap<>();
            korisceni.put((PojamElement) pojamElement,0);
            Queue<PojamElement> queue = new LinkedList<>();
            queue.add((PojamElement) pojamElement);

                while(!queue.isEmpty()){
                    PojamElement pe=queue.poll();
                    for(MapNode e:mapView.getMindMap().getChildren()){
                        if(e instanceof VezaElement){
                            if(((VezaElement) e).getPE1().equals(pe)){
                                if(!korisceni.containsKey(((VezaElement) e).getPE2())){
                                    korisceni.put(((VezaElement) e).getPE2(),korisceni.get(pe)+1);
                                    queue.add(((VezaElement) e).getPE2());
                                }
                            }
                            if(((VezaElement) e).getPE2().equals(pe)){
                                if(!korisceni.containsKey(((VezaElement) e).getPE1())){
                                    korisceni.put(((VezaElement) e).getPE1(),korisceni.get(pe)+1);
                                    queue.add(((VezaElement) e).getPE1());
                                }
                            }
                        }
                    }

                }

                int nivo=0;
            for (Map.Entry<PojamElement,Integer> entry : korisceni.entrySet())
                if(entry.getValue()>nivo)nivo=entry.getValue();
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=nivo;j++)
                list.add(-1);
            for (Map.Entry<PojamElement,Integer> entry : korisceni.entrySet()){
                int br=entry.getValue();
                list.set(br,list.get(br)+1);
                entry.getKey().setPosition(new Point(25+entry.getValue()*300,25+list.get(entry.getValue())*75));
            }

            update(this);
        }

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null)subscribers = new ArrayList<>();
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        for(ISubscriber s: subscribers) {
            s.update(notification);
        }
    }


    public void setSelectPainter(Point a, Point b) {
        if(selectPainter == null) selectPainter = new SelectPainter(a,b);
        selectPainter.setY(b);
    }

    public void removeSelectedPainter(){
        selectPainter = null;
        update(this);
    }

    public void saveAsPNG() {
        JFileChooser jfc = new JFileChooser();
        File file = null;
        if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);

            this.paint(img.getGraphics());
            try {
                ImageIO.write(img, "png", file);

            } catch (Exception e) {
                System.out.println("Nije sacuvano" + e.getMessage());
            }

        }
    }
}

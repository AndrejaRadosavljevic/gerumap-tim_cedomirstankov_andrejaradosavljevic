package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.controller.update.MouseController;
import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.painters.MapView;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MapTab extends JPanel implements UpdateListener, ISubscriber {

        private MapView mapView;
        private Element selected;

    public MapTab(MindMap selected) {
        //addMouseListener();
        mapView=new MapView(selected);

        addMouseListener(new MouseController());

        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke=new BasicStroke(5F);
        g2.setStroke(stroke);
        //Ellipse2D.Float ln=new
        //        Ellipse2D.Float(0F,0F,250F,230F);
       // g2.draw(ln);

            for(ElementPainter elementPainter : mapView.getPainters()){
                //Ovde se iscrtavaju elementi uz pomoc g2 grafike
                System.out.println("/////"+elementPainter.getElement().name);
                elementPainter.paint(g2,elementPainter.getElement());
                //System.out.println("aa"+((PojamElement)elementPainter.getElement()).getPosition());
            }


        System.out.println("Da");
        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }

    public void updateSelected(String name, Stroke stroke,Paint paint){
        selected.setName(name);
        selected.setStroke(stroke);
        selected.setPaint(paint);
        mapView.updateList();
        updatePerformed(new UpdateEvent(this));
    }

    public void setSelected(Point x) {
        selected = mapView.getMindMap().getChildOnLocation(x);
    }

    public void addPainter(ElementPainter elementPainter){
        elementPainter.getElement().setParent(mapView.getMindMap());
        mapView.addPainter(elementPainter);
        updatePerformed(new UpdateEvent(this));
    }


    public void removePainter(Point x){
        mapView.removeChild(x);
        updatePerformed(new UpdateEvent(this));
    }


    public void addVeza(Point x, Point y) {
        mapView.addPainter(x,y);
        updatePerformed(new UpdateEvent(this));
    }

    @Override
    public void update(Object notification) {
        updatePerformed(new UpdateEvent(this));
    }
}

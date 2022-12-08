package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.controller.update.MouseController;
import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.painters.MapView;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapTab extends JPanel implements UpdateListener, ISubscriber {

        private MapView mapView;

        private List<Element> selectedElements;


    public MapTab(MindMap selected) {
        //addMouseListener();
        mapView=new MapView(selected);
        selectedElements = new ArrayList<>();


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

            for(ElementPainter elementPainter : mapView.getPainters()){
                //Ovde se iscrtavaju elementi uz pomoc g2 grafike
                elementPainter.paint(g2,elementPainter.getElement());
            }


        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }


//
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
        Element element = mapView.getMindMap().getChildOnLocation(x);

        if(element!=null)selectedElements.add(element);
    }

    public void addPainter(ElementPainter elementPainter){
        elementPainter.getElement().setParent(mapView.getMindMap());
        mapView.addPainter(elementPainter);
        updatePerformed(new UpdateEvent(this));
    }


    public void removePainter(Point x){

        mapView.removeChild(x);
        if(!mapView.containsElementOnPoint(x))selectedElements.remove(mapView.getMindMap().getChildOnLocation(x));
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

    public ElementPainter getPainter(Element element){
        return mapView.getPainter(element);
    }

    public void drawMyLine(Point a, Point b) {
        System.out.println("/");
        Graphics2D g2 = (Graphics2D) getGraphics();
        BasicStroke stroke=new BasicStroke(5F);
        Shape shape = new Line2D.Double(a,b);
        g2.setStroke(stroke);
        g2.setPaint(Color.BLACK);
        g2.draw(shape);
        g2.fill(shape);


    }
}

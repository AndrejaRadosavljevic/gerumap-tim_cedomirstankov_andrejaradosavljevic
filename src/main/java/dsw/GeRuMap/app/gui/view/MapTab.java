package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.MouseController;
import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.painters.ElementPainter;
import dsw.GeRuMap.app.painters.MapView;
import dsw.GeRuMap.app.painters.PojamPainter;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter
public class MapTab extends JPanel implements UpdateListener {

        private MapView mapView;
        private Element selected;

    public MapTab(MindMap selected) {
        //addMouseListener();
        mapView=new MapView(selected);

        add(new Label(selected.getName()));

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

            for(MapNode e:mapView.getMindMap().getChildren()){
                //Ovde se iscrtavaju elementi uz pomoc g2 grafike
                PojamPainter pojamPainter = new PojamPainter((Element) e);

                pojamPainter.paint(g2,(Element) e);
                System.out.println("/"+e.getName());
            }


        System.out.println("Da");
        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }



    public void setSelected(Point x) {
        selected = mapView.getMindMap().getChildOnLocation(x);
    }

    public void addPainter(ElementPainter elementPainter){
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
}

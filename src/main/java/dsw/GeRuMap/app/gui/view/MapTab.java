package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.MouseController;
import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter
public class MapTab extends JPanel implements UpdateListener {

        private MindMap mindMap;
        private Element selected;

    public MapTab(MindMap selected) {
        //addMouseListener();
        this.mindMap = selected;

        add(new Label(selected.getName()));

        addMouseListener(new MouseController());

        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);

    }

    protected void paintComponent(Graphics g){
//        g.setColor(new Color(255,255,255));
//            super.paintComponent(g);
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OUT,0.8f));
//            g2.drawLine(0,0,200,200);

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke=new BasicStroke(5F);
        g2.setStroke(stroke);
        Ellipse2D.Float ln=new
                Ellipse2D.Float(0F,0F,250F,230F);
        g2.draw(ln);
            /*
            for(MapNode e:selected.getChildren()){
                //Ovde se iscrtavaju elementi uz pomoc g2 grafike
                ElementPainter ep = new ElementPaiter();
                ep.paint(g2,(Element) e);     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.println(e.getName());
            }

             */
        System.out.println("Da");
        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }



    public void setSelected(Point x) {
        selected = mindMap.getChildOnLocation(x);
    }
}

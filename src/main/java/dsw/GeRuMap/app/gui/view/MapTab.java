package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.controller.update.UpdateListener;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.painters.ElementPainter;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MapTab extends JPanel implements UpdateListener {

        private MindMap selected;

    public MapTab(MindMap selected) {
        //addMouseListener();
        this.selected = selected;

        add(new Label(selected.getName()));

        setBackground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);

    }

    protected void paintComponent(Graphics g){
        g.setColor(new Color(255,255,255));
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OUT,0.8f));
            g2.draw(new Rectangle());
            for(MapNode e:selected.getChildren()){
                //Ovde se iscrtavaju elementi uz pomoc g2 grafike
                ElementPainter ep = ((Element)e).getPainter();
                ep.paint(g2,(Element) e);
                System.out.println(e.getName());
            }
        System.out.println("Da");
        }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }
}

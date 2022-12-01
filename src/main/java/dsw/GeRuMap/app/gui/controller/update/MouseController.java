package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.editorActions.*;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

public class MouseController extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();
            GeneralPath gp=new GeneralPath();


            //Odradjivanje selektovane operacije. Neophodno da se definisu doState() metode
            //MindMap mt = (MindMap) MainFrame.getInstance().getTabPanel().getSelected().getMapNode();
            MainFrame.getInstance().getTabPanel().getStateManager().getCurrent().doState(position);
            //Paint fill = new GradientPaint(position.x, position.y, Color.RED,
            //	position.x+100, position.y+50, Color.BLUE);
            Paint fill = new Color(255,255,255);


        }
    }
}

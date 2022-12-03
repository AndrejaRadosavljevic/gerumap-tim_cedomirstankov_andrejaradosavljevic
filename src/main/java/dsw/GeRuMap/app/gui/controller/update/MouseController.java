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
    private Point a=null,b;

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();
            GeneralPath gp=new GeneralPath();

            a = e.getPoint();

            MainFrame.getInstance().getTabPanel().getStateManager().getCurrent().doState(position);

            Paint fill = new Color(255,255,255);


        }
    }
/////???????????????????? ne razumem posllednu stavku u nedelji 8 pod *
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        b=e.getPoint();

    }
}

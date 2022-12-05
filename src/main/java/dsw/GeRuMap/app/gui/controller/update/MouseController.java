package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.editorActions.*;
import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.state.concrete.NewPojamState;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import java.security.Provider;
import java.util.List;

public class MouseController extends MouseAdapter {
    private Point a=null,b;

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();

            a = e.getPoint();

            State state =  MainFrame.getInstance().getTabPanel().getStateManager().getCurrent();

            state.doState(position);




        }
    }
/////???????????????????? ne razumem posllednu stavku u nedelji 8 pod *
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (e.getButton()==MouseEvent.BUTTON1){
            b = e.getPoint();
            System.out.println(a+"   "+b);
            MainFrame.getInstance().getTabPanel().getStateManager().getCurrent().doState(a,b);
            a=null;
            b=null;

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (e.getButton()==MouseEvent.BUTTON1){
            b = e.getPoint();
            Graphics g = MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent().getGraphics();
            g.drawLine(a.x,a.y,b.x,b.y);

        }
    }


}

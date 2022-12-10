package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.editorActions.*;
import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.painters.MapView;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.state.concrete.MoveState;
import dsw.GeRuMap.app.gui.state.concrete.NewPojamState;
import dsw.GeRuMap.app.gui.state.concrete.NewVezaState;
import dsw.GeRuMap.app.gui.state.concrete.SelectState;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.GeneralPath;
import java.security.Provider;
import java.util.List;

public class MouseController extends MouseAdapter {
    private Point a=null,b,c;

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton()==MouseEvent.BUTTON1){
            Point position = e.getPoint();

            c=a=b = e.getPoint();

            State state =  MainFrame.getInstance().getTabPanel().getStateManager().getCurrent();

            if(state instanceof NewPojamState){
                for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
                    if(ep1.getElement() instanceof PojamElement){
                        double x=((PojamElement)ep1.getElement()).getPosition().getX();
                        double y=((PojamElement)ep1.getElement()).getPosition().getY();
                        if(position.getX()>=x-200 && position.getX()<=x+200 && position.getY()>=y-50 && position.getY()<=y+50){
                            return;
                        }
                    }

                }
            }
           if(state instanceof SelectState){
               List<Element> elementList = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelectedElements();
               for(Element el:elementList){
                   ((PojamElement)el).setSelected(false);
               }
               elementList.removeAll(elementList);
           }
           state.doState(position);
           b=null;
            System.out.println("klik");



        }
    }
/////???????????????????? ne razumem posllednu stavku u nedelji 8 pod *
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        if (e.getButton()==MouseEvent.BUTTON1){
            b = e.getPoint();
            System.out.println(a+" |razmak|  "+b);
            MainFrame.getInstance().getTabPanel().getStateManager().getCurrent().doState(a,b);
            a=null;
            b=null;

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        System.out.println("|");
            c=b;
            b = e.getPoint();
            State state = MainFrame.getInstance().getTabPanel().getStateManager().getCurrent();
            if( state instanceof NewVezaState)
                ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).drawMyLine(c,b);
            //mora jos da se sredi

            //if(state instanceof MoveState) state.doState(c,b);




    }


}

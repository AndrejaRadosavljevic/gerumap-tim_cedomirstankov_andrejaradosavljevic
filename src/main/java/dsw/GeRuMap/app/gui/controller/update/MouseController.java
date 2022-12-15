package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.state.concrete.*;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                double f = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getScale();
                double tx = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransX();
                double ty = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransY();
                Point positionElement=new Point((int) position.getX(), (int) position.getY());
                positionElement.translate((int) (-tx*f), (int) (-ty*f));
                for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
                    if(ep1.getElement() instanceof PojamElement){
                        double x=((PojamElement)ep1.getElement()).getPosition().getX()*f;
                        double y=((PojamElement)ep1.getElement()).getPosition().getY()*f;

                        if(positionElement.getX()>=x-200*f && positionElement.getX()<=x+200*f && positionElement.getY()>=y-50*f && positionElement.getY()<=y+50*f){
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
        State state = MainFrame.getInstance().getTabPanel().getStateManager().getCurrent();
        if (e.getButton()==MouseEvent.BUTTON1){
            b = e.getPoint();
            System.out.println(a+" |razmak|  "+b);
            state.doState(a,b);
            a=null;
            b=null;

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        System.out.println("|*");
            c=b;
            b = e.getPoint();
            State state = MainFrame.getInstance().getTabPanel().getStateManager().getCurrent();
            if(state instanceof MoveState){
                state.doState(a,b);
            }
            if(state instanceof SelectState || state instanceof BrisiElementState){
                ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelectPainter().setY(e.getPoint());
                ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).updatePerformed(new UpdateEvent(this));
            }

            if( state instanceof NewVezaState)
                ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).drawMyLine(c,b);
            //mora jos da se sredi

            //if(state instanceof MoveState) state.doState(c,b);




    }



}

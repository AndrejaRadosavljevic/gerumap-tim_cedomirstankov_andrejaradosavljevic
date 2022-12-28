package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.command.komande.BrisiElementCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.VezaElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrisiElementState implements State {

    private double tx;
    private double ty;
    private double s;

    @Override
    public void doState(Point x) {

        tx = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransX();
        ty = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransY();
        s = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getScale();

        doState(x,x);
        //((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).removePainter(x);
        System.out.println("Brisi");
    }

    @Override
    public void doState(Point a, Point b) {
        ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).setSelectPainter(null);

        a.translate((int) (-tx*s), (int) (-ty*s));
        b.translate((int) (-tx*s), (int) (-ty*s));

        Rectangle selection=new Rectangle(a);
        selection.setFrameFromDiagonal(a,b);
        System.out.println(a+"||||||||"+b);

        List<Element> elements = new ArrayList<>();

        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().
                getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement) {
                if(selection.intersects(((PojamElement) ep1.getElement()).getCurentPosition().getX(),((PojamElement) ep1.getElement()).getCurentPosition().getY(),((PojamElement) ep1.getElement()).getCurentDimensions().getWidth(),((PojamElement) ep1.getElement()).getCurentDimensions().getHeight()) && !(((PojamElement) ep1.getElement()).getSize().getWidth()==400)){
                    elements.add(ep1.getElement());
                    //System.out.println("Obrisano: "+ep1.getElement().getName());
                }
                if(((PojamElement) ep1.getElement()).hasPoint(a) && !(((PojamElement) ep1.getElement()).getSize().getWidth()==400))
                    elements.add(ep1.getElement());
            }
            else{
                if(((VezaElement)ep1.getElement()).hasPoint(a))elements.add(ep1.getElement());
                if(selection.intersectsLine(((VezaElement) ep1.getElement()).getPE1().getPosition().getX(),
                        ((VezaElement) ep1.getElement()).getPE1().getPosition().getY(),
                            ((VezaElement) ep1.getElement()).getPE2().getPosition().getX(),
                                ((VezaElement) ep1.getElement()).getPE2().getPosition().getY())){
                    elements.add(ep1.getElement());
                }
            }
        }



        if(elements.size()!=0){
            MindMap map = (MindMap) elements.get(0).getParent();
            BrisiElementCommand command = new BrisiElementCommand(map,elements);
            map.getCommandManager().addCommand(command);
        }

    }
}

package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrisiElementState implements State {

    void obrisi(Point x){

    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).removePainter(x);
        System.out.println("Brisi");
    }

    @Override
    public void doState(Point a, Point b) {
        Rectangle selection=new Rectangle(a);
        selection.setFrameFromDiagonal(a,b);

        List<Element> elements = new ArrayList<>();
        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement) {
                if(selection.intersects(((PojamElement) ep1.getElement()).getCurentPoint().getX(),((PojamElement) ep1.getElement()).getCurentPoint().getY(),
                        ((PojamElement) ep1.getElement()).getCurentSize().getWidth(),((PojamElement) ep1.getElement()).getCurentSize().getHeight())){
                    elements.add(ep1.getElement());
                    System.out.println("Obrisano: "+ep1.getElement().getName());
                }
            }
        }
        for(Element element:elements){

            doState(((PojamElement) element).getPosition());
        }
    }
}

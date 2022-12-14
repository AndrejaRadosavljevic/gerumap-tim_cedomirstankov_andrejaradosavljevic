package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrisiElementState implements State {

    void obrisi(Point x){

    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelectedElement(x);
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).removePainter(x);
        System.out.println("Brisi");
    }

    @Override
    public void doState(Point a, Point b) {
        ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).setSelectPainter(null);


        Rectangle selection=new Rectangle(a);
        selection.setFrameFromDiagonal(a,b);
        System.out.println(a+"||||||||"+b);

        List<Element> elements = new ArrayList<>();

        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().
                getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement) {
                if(selection.intersects(((PojamElement) ep1.getElement()).getCurentPosition().getX(),((PojamElement) ep1.getElement()).getCurentPosition().getY(),((PojamElement) ep1.getElement()).getCurentDimensions().getWidth(),((PojamElement) ep1.getElement()).getCurentDimensions().getHeight())){
                    elements.add(ep1.getElement());
                    System.out.println("Obrisano: "+ep1.getElement().getName());
                }
            }
        }
        System.out.println(elements+"AAAAAAAAAAAAAAAA");
        for(Element element:elements){
            ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).
                    removePainter(element);
        }
        ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).updatePerformed(new UpdateEvent(this));
    }
}

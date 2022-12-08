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
        List<Element> elements = new ArrayList<>();
        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement) {
                double x1 = ((PojamElement) ep1.getElement()).getPosition().getX();
                double y1 = ((PojamElement) ep1.getElement()).getPosition().getY();
                if (x1 >= a.getX() && y1 >= a.getY() && x1 <= b.getX() && y1 <= b.getY()) {
                    elements.add(ep1.getElement());
                    System.out.println("Obrisan: " + ((PojamElement) ep1.getElement()).getName());
                }
                if (x1 >= b.getX() && y1 >= b.getY() && x1 <= a.getX() && y1 <= a.getY()) {
                    elements.add(ep1.getElement());
                    System.out.println("Obrisan: " + ((PojamElement) ep1.getElement()).getName());
                }
                if (x1 >= a.getX() && x1 <= b.getX() && y1 >= b.getY() && y1 <= a.getY()) {
                    elements.add(ep1.getElement());
                    System.out.println("Obrisan: " + ((PojamElement) ep1.getElement()).getName());
                }
                if (x1 > b.getX() && x1 < a.getX() && y1 > a.getY() && y1 < b.getY()) {
                    elements.add(ep1.getElement());
                    System.out.println("Obrisan: " + ((PojamElement) ep1.getElement()).getName());
                }
            }
        }
        for(Element element:elements){

            doState(((PojamElement) element).getPosition());
        }
    }
}

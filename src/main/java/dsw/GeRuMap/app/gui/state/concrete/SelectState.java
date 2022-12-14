package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.painters.PojamPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SelectState implements State {

    Rectangle selection = new Rectangle();
    void selektuj(){
        //uzimamo selektovano i cuvamo ga.
    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelectedElement(x);
        System.out.println("Select");
    }

    @Override
    public void doState(Point a, Point b) {
        ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).setSelectPainter(null);
        selection=new Rectangle(a);
        selection.setFrameFromDiagonal(a,b);

        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement){
                double x1=((PojamElement)ep1.getElement()).getPosition().getX();
                double y1=((PojamElement)ep1.getElement()).getPosition().getY();
//                if(x1>=a.getX() && y1>=a.getY() && x1<=b.getX() && y1<=b.getY()){
//                    doState(((PojamElement) ep1.getElement()).getPosition());
//                    System.out.println("selektovan: "+((PojamElement) ep1.getElement()).getName());
//                }
//                if(x1>=b.getX() && y1>=b.getY() && x1<=a.getX() && y1<=a.getY()){
//                    doState(((PojamElement) ep1.getElement()).getPosition());
//                    System.out.println("selektovan: "+((PojamElement) ep1.getElement()).getName());
//                }
//                if(x1>=a.getX() && x1<=b.getX() && y1>=b.getY() && y1<=a.getY()){
//                    doState(((PojamElement) ep1.getElement()).getPosition());
//                    System.out.println("selektovan: "+((PojamElement) ep1.getElement()).getName());
//                }
//                if(x1>b.getX() && x1<a.getX() && y1>a.getY() && y1<b.getY()){
//                    doState(((PojamElement) ep1.getElement()).getPosition());
//                    System.out.println("selektovan: "+((PojamElement) ep1.getElement()).getName());
//                }
                if(selection.intersects(((PojamElement) ep1.getElement()).getCurentPosition().getX(),((PojamElement) ep1.getElement()).getCurentPosition().getY(),((PojamElement) ep1.getElement()).getCurentDimensions().getWidth(),((PojamElement) ep1.getElement()).getCurentDimensions().getHeight())){
                    System.out.println("X: " + ((PojamElement) ep1.getElement()).getCurentPosition().getX() + "Y: " + ((PojamElement) ep1.getElement()).getCurentPosition().getY());
                    ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelection(ep1.getElement());
                    System.out.println("selektovan: "+((PojamElement) ep1.getElement()).getName());
                }
            }

        }
        ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).updatePerformed(new UpdateEvent(this));
    }
}
package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.controller.update.UpdateEvent;
import dsw.GeRuMap.app.gui.painters.ElementPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class SelectState implements State {

    private double tx;
    private double ty;
    private double s;
    Rectangle selection = new Rectangle();

    @Override
    public void doState(Point x) {
        tx = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransX();
        ty = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransY();
        s = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getScale();

        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelectedElement(x);
    }

    @Override
    public void doState(Point a, Point b) {
        ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).setSelectPainter(null);

        a.translate((int) (-tx*s), (int) (-ty*s));
        b.translate((int) (-tx*s), (int) (-ty*s));

        selection=new Rectangle(a);
        selection.setFrameFromDiagonal(a,b);
        for(ElementPainter ep1:((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getPainters()){
            if(ep1.getElement() instanceof PojamElement){

                if(selection.intersects(((PojamElement) ep1.getElement()).getCurentPosition().getX(),((PojamElement) ep1.getElement()).getCurentPosition().getY(),((PojamElement) ep1.getElement()).getCurentDimensions().getWidth(),((PojamElement) ep1.getElement()).getCurentDimensions().getHeight())){
                    ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelection(ep1.getElement());
                }
                if(((PojamElement) ep1.getElement()).hasPoint(a))
                    ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addSelection(ep1.getElement());

            }

        }
        ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).updatePerformed(new UpdateEvent(this));
    }
}
package dsw.GeRuMap.app.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.state.State;

import java.awt.*;

public class BrisiElementState implements State {

    void obrisi(Point x){

    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().removeChild(x);
        System.out.println("Brisi");
    }
}

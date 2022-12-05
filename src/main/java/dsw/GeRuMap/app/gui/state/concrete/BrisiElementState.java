package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.state.State;

import java.awt.*;

public class BrisiElementState implements State {

    void obrisi(Point x){

    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).removePainter(x);
        System.out.println("Brisi");
    }

    @Override
    public void doState(Point x, Point y) {

    }
}

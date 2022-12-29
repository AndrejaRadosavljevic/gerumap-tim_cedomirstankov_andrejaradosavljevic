package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;

import java.awt.*;

public class CenterState implements State {
    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).centrirajPojam(x);
    }

    @Override
    public void doState(Point x, Point y) {

    }
}

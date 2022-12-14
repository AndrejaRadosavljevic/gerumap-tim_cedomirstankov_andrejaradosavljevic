package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;

import java.awt.*;

public class MoveState implements State {

    private Point curent;
    @Override
    public void doState(Point x) {
        curent = x;
    }

    @Override
    public void doState(Point x, Point y) {
        double h = y.getX() - curent.getX();
        double w = y.getY() - curent.getY();
        curent.setLocation(y);
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).moveSelected(h,w);

    }
}

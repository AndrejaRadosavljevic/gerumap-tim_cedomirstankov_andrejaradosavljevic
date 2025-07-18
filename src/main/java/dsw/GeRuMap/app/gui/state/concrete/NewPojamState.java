package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.gui.state.State;

import java.awt.*;

public class NewPojamState implements State {

    @Override
    public void doState(Point x) {
        double f = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getScale();
        double tx =((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getTransX();
        double ty =((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getTransY();

        x = new Point((int) ((x.x)/f-tx), (int) ((x.y)/f-ty));
        NewPojamFrame.getInstance().setVisible(true);
        NewPojamFrame.getInstance().getTextField1().setText("Uneti tekst pojma");
        NewPojamFrame.getInstance().setPoint(x);
    }

    @Override
    public void doState(Point x, Point y) {

    }
}

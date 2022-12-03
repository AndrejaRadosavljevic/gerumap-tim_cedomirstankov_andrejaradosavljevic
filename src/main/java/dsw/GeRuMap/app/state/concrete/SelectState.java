package dsw.GeRuMap.app.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.state.State;

import java.awt.*;

public class SelectState implements State {

    void selektuj(){
        //uzimamo selektovano i cuvamo ga.
    }

    @Override
    public void doState(Point x) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).setSelected(x);
        System.out.println("Select");
    }

    @Override
    public void doState(Point x, Point y) {

    }
}
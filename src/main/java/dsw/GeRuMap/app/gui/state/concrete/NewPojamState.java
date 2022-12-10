package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.gui.state.State;

import java.awt.*;

public class NewPojamState implements State {

    void dodajNovPojam(int x,int y){
        //PojamElement pojamElement=new PojamElement();
    }

    @Override
    public void doState(Point x) {
        double f = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getScale();
        x = new Point((int) (x.x/f), (int) (x.y/f));
        NewPojamFrame.getInstance().setVisible(true);
        NewPojamFrame.getInstance().getTextField1().setText("Uneti tekst pojma");
        NewPojamFrame.getInstance().setPoint(x);
        System.out.println("Pojam");
    }

    @Override
    public void doState(Point x, Point y) {

    }
}

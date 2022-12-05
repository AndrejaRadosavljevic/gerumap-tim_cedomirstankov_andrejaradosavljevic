package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.gui.state.State;

import java.awt.*;

public class NewVezaState implements State {

    void dodajVezu(PojamElement pe1, PojamElement pe2){
        //VezaElement = new VezaElement();
    }

    @Override
    public void doState(Point x) {

    }
    @Override
    public void doState(Point x, Point y) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addVeza(x,y);
        System.out.println("Veza");
    }
}

package dsw.GeRuMap.app.state.concrete;

import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.state.State;

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

        System.out.println("Veza");
    }
}

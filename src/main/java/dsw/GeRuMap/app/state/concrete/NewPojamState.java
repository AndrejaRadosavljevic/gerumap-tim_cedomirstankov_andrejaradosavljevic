package dsw.GeRuMap.app.state.concrete;

import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.state.State;

import java.awt.*;

public class NewPojamState implements State {

    void dodajNovPojam(int x,int y){
        //PojamElement pojamElement=new PojamElement();
    }

    @Override
    public void doState(Point x) {
        NewPojamFrame.getInstance().setVisible(true);
        NewPojamFrame.getInstance().getTextField1().setText("Uneti tekst pojma");
        NewPojamFrame.getInstance().setPoint(x);
        System.out.println("Pojam");
    }

    @Override
    public void doState(Point x, Point y) {

    }
}

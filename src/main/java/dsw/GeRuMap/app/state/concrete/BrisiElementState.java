package dsw.GeRuMap.app.state.concrete;

import dsw.GeRuMap.app.state.State;

import java.awt.*;

public class BrisiElementState implements State {

    void obrisi(int x,int y){
        //...
    }

    @Override
    public void doState(Point x) {
        System.out.println("Brisi");
    }
}

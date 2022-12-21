package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.command.komande.NewPojamCommand;
import dsw.GeRuMap.app.mapRepository.command.komande.NewVezaCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.gui.state.State;

import java.awt.*;

public class NewVezaState implements State {

    private Point a, b;


    void dodajVezu(PojamElement pe1, PojamElement pe2){
        //VezaElement = new VezaElement();
    }

    @Override
    public void doState(Point x) {

        a = x;

    }
    @Override
    public void doState(Point x, Point y) {
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addVeza(x,y);
        //MindMap mapa = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getMindMap();
        //NewVezaCommand newVezaCommand=new NewVezaCommand(mapa,x,y);
        //mapa.getCommandManager().addCommand(newVezaCommand);
        System.out.println("Veza");
    }
}

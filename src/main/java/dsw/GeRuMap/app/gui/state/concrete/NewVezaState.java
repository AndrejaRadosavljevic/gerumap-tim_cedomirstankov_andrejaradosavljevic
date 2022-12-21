package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.command.komande.NewPojamCommand;
import dsw.GeRuMap.app.mapRepository.command.komande.NewVezaCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

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
        MindMap mapa = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMapView().getMindMap();
        double f = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getScale();
        double tx = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransX();
        double ty = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getTransY();
        Point x1=new Point((int) x.getX(), (int) x.getY());
        Point y1=new Point((int) y.getX(), (int) y.getY());
        x1.translate((int) (-tx*f), (int) (-ty*f));
        y1.translate((int) (-tx*f), (int) (-ty*f));
        Element pojamElement1= mapa.getChildOnLocation(x1);
        Element pojamElement2= mapa.getChildOnLocation(y1);
        if(pojamElement1 instanceof PojamElement && pojamElement2 instanceof PojamElement && pojamElement1!=null && pojamElement2!=null){
            NewVezaCommand newVezaCommand=new NewVezaCommand(mapa,new VezaElement("veza("+x.x+","+x.y+","+y.x+","+y.y+")",mapa, (PojamElement) pojamElement1, (PojamElement) pojamElement2));
            mapa.getCommandManager().addCommand(newVezaCommand);
        }
        System.out.println("Veza");
    }
}

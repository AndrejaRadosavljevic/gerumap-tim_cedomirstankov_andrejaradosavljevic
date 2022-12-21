package dsw.GeRuMap.app.mapRepository.command.komande;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.command.AbstractCommand;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.awt.*;

public class NewVezaCommand extends AbstractCommand {

    private MindMap map;
    private Point a, b;

    public NewVezaCommand(MindMap map, Point a,Point b){
        this.map=map;
        this.a=a;
        this.b=b;
    }
    @Override
    public void doCommand() {
        //((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addVeza(a,b);
    }

    @Override
    public void undoCommand() {

    }
}

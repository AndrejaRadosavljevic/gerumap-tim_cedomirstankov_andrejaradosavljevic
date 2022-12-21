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
    private VezaElement vezaElement;

    public NewVezaCommand(MindMap map, VezaElement vezaElement){
        this.map=map;
        this.vezaElement=vezaElement;
    }
    @Override
    public void doCommand() {
        map.addChild(vezaElement);
    }

    @Override
    public void undoCommand() {
        map.removeChild(vezaElement);
    }
}

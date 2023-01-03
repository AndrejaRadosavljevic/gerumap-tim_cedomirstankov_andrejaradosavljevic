package dsw.GeRuMap.app.mapRepository.command.komande;

import dsw.GeRuMap.app.mapRepository.command.AbstractCommand;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;

public class NewPojamCommand extends AbstractCommand {

    private MindMap map;

    private PojamElement pojamElement;

    public NewPojamCommand(MindMap map, PojamElement pojamElement){
        this.map=map;
        this.pojamElement=pojamElement;
    }
    @Override
    public void doCommand() {
        map.addChild(pojamElement);
        System.out.println("izvrsen doCommand u NewPojamCommand");
    }

    @Override
    public void undoCommand() {
        map.removeChild(pojamElement);
        System.out.println("izvrsen doCommand u NewPojamCommand");
    }
}

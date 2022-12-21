package dsw.GeRuMap.app.mapRepository.command.komande;

import dsw.GeRuMap.app.gui.painters.PojamPainter;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.command.AbstractCommand;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;

public class NewPojamCommand extends AbstractCommand {

    private MindMap map;

    private PojamElement pojamElement;

    public NewPojamCommand(MindMap map, PojamElement pojamElement){
        this.map=map;
        this.pojamElement=pojamElement;
    }
    @Override
    public void doCommand() {
        ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addPainter(new PojamPainter(pojamElement));
        System.out.println("izvrsen doCommand u NewPojamCommand");
    }

    @Override
    public void undoCommand() {
        ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).removePainter(new PojamPainter(pojamElement).getElement());
        System.out.println("izvrsen doCommand u NewPojamCommand");
    }
}

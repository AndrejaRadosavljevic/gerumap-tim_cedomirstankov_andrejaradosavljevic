package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.messagegenerator.MessageGeneratorImplementation;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteProjectAction extends AbstractGeRuMapAction {
    public DeleteProjectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/minus.png"));
        putValue(NAME, "Delete Project");
        putValue(SHORT_DESCRIPTION, "Delete Project");

    }

    public void actionPerformed(ActionEvent arg0){
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected==null) return;
       // MainFrame.getInstance().getMapTree().
        if(selected.getMapNode() instanceof ProjectExplorer){
            MessageGeneratorImplementation.getInstance().generate(Type.BRISANJE_PROJECT_EXPLORERA_ERROR);
        }
        MainFrame.getInstance().getMapTree().deleteChild(selected);
        MainFrame.getInstance().getMapTree().deselect();

    }

}

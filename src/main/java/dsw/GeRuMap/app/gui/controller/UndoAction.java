package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractGeRuMapAction{

    public UndoAction(){
        putValue(SMALL_ICON, LoadIcon("/images/undo.png"));
        putValue(NAME,"Undo");
        putValue(SHORT_DESCRIPTION, "Undo");

    }

    public void actionPerformed(ActionEvent arg0){
        Object p = (MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent());
        if(!(p instanceof MapTab))return;
        ((MapTab)p).getMapView().getMindMap().getCommandManager().undoCommand();
    }
}

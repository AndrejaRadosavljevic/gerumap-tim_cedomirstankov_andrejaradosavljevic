package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction(){
        putValue(SMALL_ICON, LoadIcon("/images/redo.png"));
        putValue(NAME,"Redo");
        putValue(SHORT_DESCRIPTION, "Redo");

    }

    public void actionPerformed(ActionEvent arg0){
        Object p = (MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent());
        if(!(p instanceof MapTab))return;
        ((MapTab)p).getMapView().getMindMap().getCommandManager().doCommand();
    }
}

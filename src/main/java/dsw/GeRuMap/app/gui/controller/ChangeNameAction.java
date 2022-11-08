package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.changename.ChangeNameFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChangeNameAction extends AbstractRudokAction{
    public ChangeNameAction(){
       // putValue(SMALL_ICON, LoadIcon("/images/minus.png"));
        putValue(NAME, "Change Name");
        putValue(SHORT_DESCRIPTION, "Change name");
    }

    public void actionPerformed(ActionEvent arg0){
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected==null)
            return;
        if(selected.getMapNode() instanceof Project){
            ChangeNameFrame.getInstance().setVisible(true);
        }
        // MainFrame.getInstance().getMapTree().
        //selected.setName();
    }
}

package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.InfoFrame;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.changename.ChangeNameFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PotvrdiButtonAction extends AbstractRudokAction{

    public void actionPerformed(ActionEvent arg0){
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        // MainFrame.getInstance().getMapTree().

        String ime=ChangeNameFrame.getInstance().getTextField1().getText();
        String autor=ChangeNameFrame.getInstance().getTextField2().getText();

        MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().setName(autor);
        ((Project)MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).setAutor(ime);

        ((MapTreeImplementation)MainFrame.getInstance().getMapTree()).refreshTree();
        ChangeNameFrame.getInstance().setVisible(false);
    }
}

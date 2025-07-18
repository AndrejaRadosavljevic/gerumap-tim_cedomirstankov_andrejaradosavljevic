package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.messagegenerator.MessageGeneratorImplementation;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGeRuMapAction {

    public NewProjectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");

    }

    public void actionPerformed(ActionEvent arg0) {

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        if (selected == null) return;
        if (selected.getMapNode() instanceof MindMap) {
            return;
        }
        MainFrame.getInstance().getMapTree().addChild(selected);


        if (selected.getMapNode() instanceof Project)
            ((Project) selected.getMapNode()).notifySubscriber(selected.getMapNode().getName());

        if (selected.getMapNode() instanceof Element) {
            MainFrame.getInstance().getMessageGenerator().generate(Type.DODAVANJE_DETETA_ELEMENTU_ERROR);
        }

    }

}

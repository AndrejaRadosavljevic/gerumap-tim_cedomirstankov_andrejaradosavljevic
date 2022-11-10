package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.changename.ChangeNameFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;

public class ChangeNameAction extends AbstractGeRuMapAction {
    public ChangeNameAction(){
        putValue(SMALL_ICON, LoadIcon("/images/changename.png"));
        putValue(NAME, "Change Name");
        putValue(SHORT_DESCRIPTION, "Change name");
    }

    public void actionPerformed(ActionEvent arg0){
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected==null)
            return;
        if(selected.getMapNode() instanceof Project){
            ChangeNameFrame.getInstance().setVisible(true);
        }else if(!(selected.getMapNode() instanceof Project))
            return;

        String autor = ((Project)MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).getAutor();
        String ime = MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getName();

        ChangeNameFrame.getInstance().getTextField1().setText(autor);
        ChangeNameFrame.getInstance().getTextField2().setText(ime);

        // MainFrame.getInstance().getMapTree().
        //selected.setName();
    }
}

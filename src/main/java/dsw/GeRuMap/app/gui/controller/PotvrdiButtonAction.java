package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.messagegenerator.MessageGeneratorImplementation;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.ChangeNameFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;

public class PotvrdiButtonAction extends AbstractGeRuMapAction {

    public void actionPerformed(ActionEvent arg0){
        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();

        String autor=ChangeNameFrame.getInstance().getTextField1().getText();
        String ime=ChangeNameFrame.getInstance().getTextField2().getText();


        if(ime.equals("") && autor.equals("")){
            MainFrame.getInstance().getMessageGenerator().generate(Type.PRAZNO_IME_PROJEKTA_I_AUTORA);
            return;
        }

        if(ime.equals("")){
            MainFrame.getInstance().getMessageGenerator().generate(Type.PRAZNO_IME_PROJEKTA_ERROR);
            return;
        }

        if(autor.equals("")){
            MainFrame.getInstance().getMessageGenerator().generate((Type.PRAZNO_IME_AUTORA_ERROR));
            return;
        }

        MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().setName(ime);
        ((Project)MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).setAutor(autor);

        ((MapTreeImplementation)MainFrame.getInstance().getMapTree()).refreshTree();
        ChangeNameFrame.getInstance().setVisible(false);


        if(selected.getMapNode() instanceof Project)((Project) selected.getMapNode()).notifySubscriber(1);
    }
}

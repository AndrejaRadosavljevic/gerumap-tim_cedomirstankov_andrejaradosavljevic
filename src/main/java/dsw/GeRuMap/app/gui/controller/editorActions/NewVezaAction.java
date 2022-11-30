package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class NewVezaAction extends AbstractGeRuMapAction {
    public NewVezaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/veza.png"));
        putValue(NAME, "Nova veza");
        putValue(SHORT_DESCRIPTION, "Nova veza");
    }
    public void actionPerformed(ActionEvent arg0){
        MainFrame.getInstance().getStateManager().setNewVezaState();
    }
}

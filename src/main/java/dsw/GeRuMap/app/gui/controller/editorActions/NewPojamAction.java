package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class NewPojamAction extends AbstractGeRuMapAction {
    public NewPojamAction(){
        putValue(SMALL_ICON, LoadIcon("/images/novi_pojam.png"));
        putValue(NAME, "Novi pojam");
        putValue(SHORT_DESCRIPTION, "Novi pojam");
    }
    public void actionPerformed(ActionEvent arg0){
        MainFrame.getInstance().getStateManager().setNewPojamState();
    }
}

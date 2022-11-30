package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectAction extends AbstractGeRuMapAction {
    public SelectAction(){
        putValue(SMALL_ICON, LoadIcon("/images/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }
    public void actionPerformed(ActionEvent arg0){
        MainFrame.getInstance().getTabPanel().startSelect();
    }
}

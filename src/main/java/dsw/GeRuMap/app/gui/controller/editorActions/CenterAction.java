package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class CenterAction extends AbstractGeRuMapAction {
    public CenterAction(){
        putValue(SMALL_ICON, LoadIcon("/images/Center.png"));
        putValue(NAME, "Center element");
        putValue(SHORT_DESCRIPTION, "Center element");
    }
    public void actionPerformed(ActionEvent arg0) {
        MainFrame.getInstance().getTabPanel().startCenter();
    }

}

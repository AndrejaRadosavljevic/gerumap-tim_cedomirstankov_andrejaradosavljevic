package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class BrisiElementAction extends AbstractGeRuMapAction {
    public BrisiElementAction(){
        putValue(SMALL_ICON, LoadIcon("/images/obrisi_element.png"));
        putValue(NAME, "Brisi element");
        putValue(SHORT_DESCRIPTION, "Brisi element");
    }
    public void actionPerformed(ActionEvent arg0){
        MainFrame.getInstance().getTabPanel().startBrisiElement();
    }
}

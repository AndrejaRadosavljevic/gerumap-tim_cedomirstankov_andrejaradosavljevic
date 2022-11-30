package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;

public class SelectAction extends AbstractGeRuMapAction {
    public SelectAction(){
        putValue(SMALL_ICON, LoadIcon("/images/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }
}

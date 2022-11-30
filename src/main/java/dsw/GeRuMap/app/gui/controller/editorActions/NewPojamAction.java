package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;

public class NewPojamAction extends AbstractGeRuMapAction {
    public NewPojamAction(){
        putValue(SMALL_ICON, LoadIcon("/images/changename.png"));
        putValue(NAME, "Novi pojam");
        putValue(SHORT_DESCRIPTION, "Novi pojam");
    }
}

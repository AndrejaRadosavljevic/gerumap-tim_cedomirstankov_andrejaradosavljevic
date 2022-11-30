package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;

public class NewVezaAction extends AbstractGeRuMapAction {
    public NewVezaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/veza.png"));
        putValue(NAME, "Nova veza");
        putValue(SHORT_DESCRIPTION, "Nova veza");
    }
}

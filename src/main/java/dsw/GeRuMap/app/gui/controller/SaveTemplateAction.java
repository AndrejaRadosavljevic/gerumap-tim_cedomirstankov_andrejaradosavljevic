package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;

import java.awt.event.ActionEvent;

public class SaveTemplateAction extends AbstractGeRuMapAction{

    public SaveTemplateAction()  {
        putValue(SMALL_ICON, LoadIcon("/images/plus.png"));
        putValue(NAME, "Save Template");
        putValue(SHORT_DESCRIPTION, "Save Template");
    }

    public void actionPerformed(ActionEvent arg0){

        MainFrame.getInstance().getMapTree().saveSelectedMap();
    }
}

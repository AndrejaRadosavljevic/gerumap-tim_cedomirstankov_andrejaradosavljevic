package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;

import java.awt.event.ActionEvent;

public class SaveAsPngAction extends AbstractGeRuMapAction{
    public SaveAsPngAction()  {
        putValue(SMALL_ICON, LoadIcon("/images/PNG.png"));
        putValue(NAME, "Save as Png");
        putValue(SHORT_DESCRIPTION, "Save as Png");
    }

    public void actionPerformed(ActionEvent arg0){

        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).saveAsPNG();
    }
}

package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.view.InfoFrame;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGeRuMapAction {

    private InfoFrame infoFrame;

    public  InfoAction(){
        putValue(SMALL_ICON, LoadIcon("/images/info.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }

    public void actionPerformed(ActionEvent arg0){
        infoFrame = InfoFrame.getInstance();
        infoFrame.setVisible(true);
    }
}

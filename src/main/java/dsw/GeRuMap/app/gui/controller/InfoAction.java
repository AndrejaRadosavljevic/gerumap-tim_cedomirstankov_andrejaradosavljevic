package dsw.GeRuMap.app.gui.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRudokAction{

    private InfoAction infoAction;

    public  InfoAction(){
        ///putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/info.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }


    public void actionPerformed(ActionEvent arg0){
        infoAction = new InfoAction();

    }

    public void initialise() {
    }
}

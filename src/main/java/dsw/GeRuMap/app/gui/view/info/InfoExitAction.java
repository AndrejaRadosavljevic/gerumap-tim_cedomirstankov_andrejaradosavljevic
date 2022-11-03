package dsw.GeRuMap.app.gui.view.info;

import dsw.GeRuMap.app.gui.controller.AbstractRudokAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoExitAction extends AbstractRudokAction {
    public  InfoExitAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/log-out.png"));
        putValue(NAME,"Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    public void actionPerformed(ActionEvent argO) {
        System.exit(0);
        //?videcemo da li ovo radi
    }
}

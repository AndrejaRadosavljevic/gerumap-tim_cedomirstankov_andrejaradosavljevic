package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.view.InfoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoButtonAction extends AbstractGeRuMapAction {
    public InfoButtonAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/log-out.png"));
        putValue(NAME,"Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    public void actionPerformed(ActionEvent argO) {

        InfoFrame.getInstance().setVisible(false);
    }
}

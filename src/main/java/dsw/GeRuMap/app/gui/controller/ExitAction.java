package dsw.GeRuMap.app.gui.controller;

import dsw.GeRuMap.app.gui.errorlogger.FileLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends AbstractGeRuMapAction {

    public  ExitAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/log-out.png"));
        putValue(NAME,"Exit");
        putValue(SHORT_DESCRIPTION, "Exit");
    }

    @Override
    public void actionPerformed(ActionEvent argO) {
        System.exit(0);
    }
}
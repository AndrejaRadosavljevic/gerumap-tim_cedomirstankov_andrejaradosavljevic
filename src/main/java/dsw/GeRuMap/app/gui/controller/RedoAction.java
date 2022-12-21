package dsw.GeRuMap.app.gui.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractGeRuMapAction{

    public RedoAction(){
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, LoadIcon("/images/redo.png"));
        putValue(NAME,"Redo");
        putValue(SHORT_DESCRIPTION, "Redo");

    }

    public void actionPerformed(ActionEvent arg0){

    }
}

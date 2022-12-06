package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.PodesavanjaFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PodesavanjaAction extends AbstractGeRuMapAction {

    public PodesavanjaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/settings.png"));
        putValue(NAME, "Podesavanja");
        putValue(SHORT_DESCRIPTION, "Podesavanja");
    }
    public void actionPerformed(ActionEvent arg0){

        if(((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelected()!=null){
            PodesavanjaFrame.getInstance().setVisible(true);
        }else{
            MainFrame.getInstance().getMessageGenerator().generate(Type.NIJE_SELEKTOVAN_POJAM);
        }



        //treba da uzme selektovan element i da otvori prozor za podesavanje elementa


    }
}

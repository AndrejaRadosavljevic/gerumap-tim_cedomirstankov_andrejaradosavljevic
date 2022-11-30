package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class PodesavanjaAction extends AbstractGeRuMapAction {
    public PodesavanjaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/settings.png"));
        putValue(NAME, "Podesavanja");
        putValue(SHORT_DESCRIPTION, "Podesavanja");
    }
    public void actionPerformed(ActionEvent arg0){
        //treba da uzme selektovan element i da otvori prozor za podesavanje elementa
    }
}

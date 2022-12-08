package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstractGeRuMapAction {
    public MoveAction(){
        putValue(SMALL_ICON, LoadIcon("/images/MoveHand.png"));
        putValue(NAME, "Move element");
        putValue(SHORT_DESCRIPTION, "Move element");
    }
    public void actionPerformed(ActionEvent arg0){
        MainFrame.getInstance().getTabPanel().startMoveElement();
    }
}

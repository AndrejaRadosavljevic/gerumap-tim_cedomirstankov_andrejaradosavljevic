package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.PodesavanjaFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PodesavanjaAction extends AbstractGeRuMapAction {

    public PodesavanjaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/settings.png"));
        putValue(NAME, "Podesavanja");
        putValue(SHORT_DESCRIPTION, "Podesavanja");
    }
    public void actionPerformed(ActionEvent arg0){
        List<Element> elements=((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelectedElements();
        if(elements.isEmpty()){
            MainFrame.getInstance().getMessageGenerator().generate(Type.NIJE_SELEKTOVAN_POJAM);
            return;
        }
        PodesavanjaFrame podesavanjaFrame=new PodesavanjaFrame();
        podesavanjaFrame.setVisible(true);

    }
}



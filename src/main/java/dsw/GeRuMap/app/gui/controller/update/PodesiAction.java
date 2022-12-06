package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.gui.view.PodesavanjaFrame;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PodesiAction extends AbstractGeRuMapAction {

    public void actionPerformed(ActionEvent arg0){
        PojamElement pojamElement= (PojamElement) ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelected();
        //pojamElement.setStroke(PodesavanjaFrame.getInstance().getTextField1());
        pojamElement.setText(PodesavanjaFrame.getInstance().getTextField2().getText());
        PodesavanjaFrame.getInstance().setVisible(false);

    }
}

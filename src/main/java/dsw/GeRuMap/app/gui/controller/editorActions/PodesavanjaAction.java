package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.PodesavanjaFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PodesavanjaAction extends AbstractGeRuMapAction {

    private PodesavanjaFrame frame;
    public PodesavanjaAction(){
        putValue(SMALL_ICON, LoadIcon("/images/settings.png"));
        putValue(NAME, "Podesavanja");
        putValue(SHORT_DESCRIPTION, "Podesavanja");
    }
    public void actionPerformed(ActionEvent arg0){
        //frame = new PodesavanjaFrame();
        //frame.setVisible(true);
        //treba da uzme selektovan element i da otvori prozor za podesavanje elementa
        if(MainFrame.getInstance().getMapTree().getSelectedNode()==null)return;
        if(((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelected() == null)return;
        Color color = JColorChooser.showDialog(null,"Izaberi novu boju", Color.BLACK);
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelected().setPaint(color);
    }
}

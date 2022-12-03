package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.messagegenerator.Type;
import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.ChangeNameFrame;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.painters.ElementPainter;
import dsw.GeRuMap.app.state.concrete.NewPojamState;

import java.awt.event.ActionEvent;

public class PotvrdiElementAction extends AbstractGeRuMapAction {

    public void actionPerformed(ActionEvent arg0){

      String text = NewPojamFrame.getInstance().getTextField1().getText();
      PojamElement pe = new PojamElement(text,null);
      ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getMindMap().addChild(pe);

      NewPojamFrame.getInstance().setVisible(false);
    }
}

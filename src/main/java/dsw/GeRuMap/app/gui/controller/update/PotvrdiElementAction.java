package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.mapRepository.command.komande.NewPojamCommand;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PotvrdiElementAction extends AbstractGeRuMapAction {

    public void actionPerformed(ActionEvent arg0){

      String text = NewPojamFrame.getInstance().getTextField1().getText();
      Color paint = Color.BLACK;
      Point point = NewPojamFrame.getInstance().getPoint();
      PojamElement pe = new PojamElement(text,null,4,paint,point,new Dimension(200,50));
      MindMap mapa = ((MapTab)(MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent())).getMapView().getMindMap();
        NewPojamCommand newPojamCommand = new NewPojamCommand(mapa,pe);
        mapa.getCommandManager().addCommand(newPojamCommand);
      NewPojamFrame.getInstance().setVisible(false);



    }
}

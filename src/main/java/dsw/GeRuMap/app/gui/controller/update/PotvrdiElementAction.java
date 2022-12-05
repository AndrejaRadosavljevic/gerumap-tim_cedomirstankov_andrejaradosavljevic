package dsw.GeRuMap.app.gui.controller.update;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.gui.painters.PojamPainter;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PotvrdiElementAction extends AbstractGeRuMapAction {

    public void actionPerformed(ActionEvent arg0){

      String text = NewPojamFrame.getInstance().getTextField1().getText();
      Stroke stroke = new BasicStroke(5);
      Paint paint = Color.BLACK;
      Point point = NewPojamFrame.getInstance().getPoint();
      PojamElement pe = new PojamElement(text,null,stroke,paint,point,new Dimension(200,50));
      ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).addPainter(new PojamPainter(pe));

      NewPojamFrame.getInstance().setVisible(false);
    }
}

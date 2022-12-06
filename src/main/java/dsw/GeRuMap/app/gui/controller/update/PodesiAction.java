package dsw.GeRuMap.app.gui.controller.update;

import
        dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.gui.view.NewPojamFrame;
import dsw.GeRuMap.app.gui.view.PodesavanjaFrame;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PodesiAction extends AbstractGeRuMapAction {

    PodesavanjaFrame podesavanjaFrame;

    public PodesiAction(PodesavanjaFrame podesavanjaFrame) {
        this.podesavanjaFrame = podesavanjaFrame;
    }

    public void actionPerformed(ActionEvent arg0){

       String text=podesavanjaFrame.getTextField2().getText();

        Integer strokeBroj=Integer.parseInt(podesavanjaFrame.getTextField1().getText());
        Stroke stroke=new BasicStroke(strokeBroj);
        Paint paint=podesavanjaFrame.getColor();
        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).updateSelected(text,stroke,paint);

        podesavanjaFrame.setVisible(false);


        //pojamElement.setText(PodesavanjaFrame.getInstance().getTextField2().getText());
        //System.out.println(pojamElement.getText());

    }
}

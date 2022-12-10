package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;

public class ZoomOutAction extends AbstractGeRuMapAction {
    public ZoomOutAction(){
        putValue(SMALL_ICON, LoadIcon("/images/zoom-out.png"));
        putValue(NAME, "ZoomOut");
        putValue(SHORT_DESCRIPTION, "ZoomOut");
    }
    public void actionPerformed(ActionEvent arg0){
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)
            ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).zoomOut();
    }
}

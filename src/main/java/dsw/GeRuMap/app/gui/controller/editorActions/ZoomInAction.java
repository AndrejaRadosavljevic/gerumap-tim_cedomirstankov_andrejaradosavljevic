package dsw.GeRuMap.app.gui.controller.editorActions;

import dsw.GeRuMap.app.gui.controller.AbstractGeRuMapAction;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractGeRuMapAction {
    public ZoomInAction(){
        putValue(SMALL_ICON, LoadIcon("/images/zoom-in.png"));
        putValue(NAME, "ZoomIn");
        putValue(SHORT_DESCRIPTION, "ZoomIn");
    }
    public void actionPerformed(ActionEvent arg0){
        if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)
            ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).zoomIn();
    }
}

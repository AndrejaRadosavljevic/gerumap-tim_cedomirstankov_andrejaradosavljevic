package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.editorActions.ZoomInAction;
import dsw.GeRuMap.app.gui.controller.editorActions.ZoomOutAction;

import javax.swing.*;

public class Toolbar extends JToolBar {
    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getDeleteProjectAction());
        add(MainFrame.getInstance().getActionManager().getOpenAction());
        add(MainFrame.getInstance().getActionManager().getSaveAction());
        add(MainFrame.getInstance().getActionManager().getSaveTemplateAction());
        add(MainFrame.getInstance().getActionManager().getChangeNameAction());
        add(MainFrame.getInstance().getActionManager().getZoomInAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutAction());
        add(MainFrame.getInstance().getActionManager().getUndoAction());
        add(MainFrame.getInstance().getActionManager().getRedoAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());

    }
}

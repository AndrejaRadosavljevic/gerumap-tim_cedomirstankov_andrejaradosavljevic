package dsw.GeRuMap.app.gui.view;

import javax.swing.*;

public class EditorBar extends JToolBar {

    public EditorBar(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getPojamAction());
        add(MainFrame.getInstance().getActionManager().getVezaAction());
        add(MainFrame.getInstance().getActionManager().getSelectAction());
        add(MainFrame.getInstance().getActionManager().getMoveAction());
        add(MainFrame.getInstance().getActionManager().getBrisiElementAction());
        add(MainFrame.getInstance().getActionManager().getPodesavanjaAction());
        add(MainFrame.getInstance().getActionManager().getCenterAction());

    }
}

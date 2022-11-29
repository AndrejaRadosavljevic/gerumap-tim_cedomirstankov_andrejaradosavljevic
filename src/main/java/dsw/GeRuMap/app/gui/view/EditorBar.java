package dsw.GeRuMap.app.gui.view;

import javax.swing.*;

public class EditorBar extends JToolBar {

    public EditorBar(){
        super(VERTICAL);
        setFloatable(false);

        //ovo ti ne radi
        add(MainFrame.getInstance().getActionManager().getExitAction());
        //dugmad
    }
}

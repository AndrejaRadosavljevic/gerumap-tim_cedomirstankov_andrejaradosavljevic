package dsw.GeRuMap.app.gui.swing;

import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {
    public SwingGui(){

    }

    @Override
    public void start(){
        MainFrame.getInstance().setVisible(true);
    }


}

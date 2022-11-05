package dsw.GeRuMap.app.gui;

import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.gui.view.MainFrame;

public class SwingGui implements Gui {
    private MainFrame instance;
    public SwingGui(){

    }

    @Override
    public void start(){
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }


}

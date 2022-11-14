package dsw.GeRuMap.app.gui;

import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.gui.messagegenerator.Message;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.PorukaFrame;

import javax.swing.*;

public class SwingGui implements Gui {
    private MainFrame instance;
    public SwingGui(){

    }

    @Override
    public void start(){
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }


    @Override
    public void update(Object notification) {
        PorukaFrame.getInstance().prikaziPoruku((Message)notification);
    }
}

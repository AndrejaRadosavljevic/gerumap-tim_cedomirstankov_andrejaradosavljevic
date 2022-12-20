package dsw.GeRuMap.app.gui.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar{

    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getChangeNameAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getUndoAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRedoAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());



        this.add(fileMenu);
    }

}

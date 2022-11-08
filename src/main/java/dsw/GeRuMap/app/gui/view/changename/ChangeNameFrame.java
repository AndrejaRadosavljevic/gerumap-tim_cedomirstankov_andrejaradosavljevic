package dsw.GeRuMap.app.gui.view.changename;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.gui.controller.ActionManager;
import dsw.GeRuMap.app.gui.tree.MapTree;
import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MyMenuBar;
import dsw.GeRuMap.app.gui.view.Toolbar;

import javax.swing.*;
import java.awt.*;

public class ChangeNameFrame extends JDialog{

    private static ChangeNameFrame instance;

    private JTextField textField1;

    private JButton button1;

    private void initialiseGUI(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4,screenHeight/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        textField1=new JTextField();
        button1=new JButton("Confirm");
        add(textField1, BorderLayout.CENTER);
        add(button1,BorderLayout.SOUTH);
    }

    private ChangeNameFrame(){

    }

    public static ChangeNameFrame getInstance(){
        if(instance==null){
            instance = new ChangeNameFrame();
            instance.initialiseGUI();
        }
        return instance;
    }
}

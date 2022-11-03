package dsw.GeRuMap.app.gui.view.info;

import dsw.GeRuMap.app.gui.controller.InfoAction;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {

    private static InfoAction instance;

    private void initialise(){
        initialiseGUI();
    }

    private void initialiseGUI(){
        JButton button = new JButton(new InfoExitAction());
        JTextField textField = new JTextField("Treba se lepse dodati");

        JPanel desktop = new JPanel();

        JScrollPane scroll = new JScrollPane();
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,desktop,button);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    public InfoAction getInstance(){
        if(instance==null){
            instance = new InfoAction();
            instance.initialise();
        }
        return instance;
    }

}

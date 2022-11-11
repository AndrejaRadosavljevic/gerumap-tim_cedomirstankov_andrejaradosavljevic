package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.ActionManager;
import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter

public class MapTabPanel extends JPanel {


  //  private static MapTabPanel instance;
    private JTabbedPane tabbedPane;
    private JLabel projectLabel;

    private MapTreeItem selected;
    public MapTabPanel() {
        selected = null;
        initialiseGUI();
    }

    public  void update(){
        selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        projectLabel.setText("Autor: "+((Project)selected.getMapNode()).getAutor()+", Project: "+selected.getMapNode().getName());

        tabbedPane.removeAll();
        for(MapNode chiled: ((Project)selected.getMapNode()).getChildren()){
            JPanel panel = new JPanel();
            panel.setName(chiled.getName());
            tabbedPane.add(panel);
        }
    }


    /*
        private void initialise(){
            //addAncestorListener();
            initialiseGUI();
        }
    */
    private void initialiseGUI() {

        projectLabel = new JLabel("Autor, Projekat:");

        tabbedPane = new JTabbedPane();


        setLayout(new BorderLayout());

        add(projectLabel, BorderLayout.NORTH);
        add(tabbedPane);

    }

/*
    public static MapTabPanel getInstance() {
        if(instance == null){
            instance = new MapTabPanel();
            instance.initialise();
        }
        return instance;
    }
     */
}

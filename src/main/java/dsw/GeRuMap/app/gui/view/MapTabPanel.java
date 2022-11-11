package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.ActionManager;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter

public class MapTabPanel extends JPanel implements ISubscriber {


  //  private static MapTabPanel instance;
    private JTabbedPane tabbedPane;
    private JLabel projectLabel;

    private MapTreeItem selected;
    public MapTabPanel() {
        selected = null;
        initialiseGUI();
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
        tabbedPane.add(new JLabel("Selektujte projekat"));


        setLayout(new BorderLayout());

        add(projectLabel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

    }

    @Override
    public void update(Object notification) {

        MapTreeItem s = MainFrame.getInstance().getMapTree().getSelectedNode();



        if(s == null){

            tabbedPane.removeAll();
            projectLabel.setText("Autor: , Project:");
            selected = s;
            updateUI();
            tabbedPane.updateUI();
            return;
        }

        if(!(s.getMapNode() instanceof Project))return;

        System.out.println(s.getMapNode().getName());
        selected = s;
        projectLabel.setText("Autor: "+((Project)selected.getMapNode()).getAutor()+", Project: "+selected.getMapNode().getName());

        tabbedPane.removeAll();
        for(MapNode chiled: ((Project)selected.getMapNode()).getChildren()){
            JPanel panel = new JPanel();
            panel.setName(chiled.getName());
            tabbedPane.add(panel);
        }
        tabbedPane.updateUI();
        updateUI();

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

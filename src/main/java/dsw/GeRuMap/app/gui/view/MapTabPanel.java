package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter

public class MapTabPanel extends JPanel implements ISubscriber {

    private static MapTabPanel instance;

    private JTabbedPane tabbedPane;
    private JLabel projectLabel;

    private MapTreeItem selected;
    private MapTabPanel() {
        selected = null;
        initialiseGUI();
    }

    public static MapTabPanel getInstance() {
        if(instance == null) instance  = new MapTabPanel();
        return instance;
    }


    private void initialiseGUI() {

        projectLabel = new JLabel("Autor:, Projekat:");

        tabbedPane = new JTabbedPane();
        tabbedPane.add(new JLabel("Selektujte projekat"));


        setLayout(new BorderLayout());

        add(projectLabel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

    }

    @Override
    public void update(Object notification) {

        if(notification instanceof MindMap){

            tabbedPane.removeAll();
            for(MapNode m:((MapNodeComposite) selected.getMapNode()).getChildren()){
                System.out.println(m.getName());
                JPanel p = new JPanel();
                p.setName(m.getName());
                tabbedPane.add(p);
            }

            tabbedPane.updateUI();
            updateUI();
        }
        if(notification instanceof Project){
            if(selected == null) return;
            if(notification == selected.getMapNode()){
                selected= null;
                tabbedPane.removeAll();

                projectLabel.setText("Autor:, Projekat:");


                tabbedPane.updateUI();
                updateUI();

                return;

            }
        }

        if(notification instanceof MapTreeItem)selected = (MapTreeItem) notification;

        if(selected == null) return;

        projectLabel.setText("Autor: "+((Project)selected.getMapNode()).getAutor()+", Projekat: "+selected.getMapNode().getName());

        tabbedPane.removeAll();
        for(MapNode m:((MapNodeComposite) selected.getMapNode()).getChildren()){
            System.out.println(m.getName());
            JPanel p = new JPanel();
            p.setName(m.getName());
            tabbedPane.add(p);
        }

        tabbedPane.updateUI();
        updateUI();
    }
}

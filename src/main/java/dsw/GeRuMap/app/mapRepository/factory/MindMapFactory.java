package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.command.CommandManager;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MindMapFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {


        MindMap mindMap = new MindMap(name, parent);

        JFileChooser jfc = new JFileChooser("sabloni");
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                mindMap = ApplicationFramework.getInstance().getSerializer().loadTemplate(file);
                mindMap.setName(name);
                mindMap.setParent(parent);
                mindMap.setCommandManager(new CommandManager());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mindMap;
    }
}

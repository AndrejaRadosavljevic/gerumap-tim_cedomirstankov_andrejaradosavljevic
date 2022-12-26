package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MindMapFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {


        MindMap mindMap = new MindMap(name,parent);
        /*
        JFileChooser jfc = new JFileChooser("sabloni");
        List<MapNode> elements = new ArrayList<>();
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                elements = ApplicationFramework.getInstance().getSerializer().loadTemplateChildren(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(MapNode element:elements){
            mindMap.addChild(element);
        }
        */
        return mindMap;
    }
}

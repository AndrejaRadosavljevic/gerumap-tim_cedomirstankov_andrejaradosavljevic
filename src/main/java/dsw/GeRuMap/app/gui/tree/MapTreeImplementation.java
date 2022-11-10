package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.tree.view.MapTreeView;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.factory.ElementFactory;
import dsw.GeRuMap.app.mapRepository.factory.MindMapFactory;
import dsw.GeRuMap.app.mapRepository.factory.ProjectFactory;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;
import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.Random;

public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if(parent == null) return;
        if(!(parent.getMapNode() instanceof MapNodeComposite))return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite)parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private MapNode createChild(MapNode mapNode) {
        if(mapNode instanceof ProjectExplorer)return new ProjectFactory().createNode("Project" + new Random().nextInt(100), mapNode);
        //if(mapNode instanceof ProjectExplorer)return new Project("Project" + new Random().nextInt(100), mapNode);
        else if(mapNode instanceof Project)return new MindMapFactory().createNode("Map"+new Random().nextInt(100), mapNode);
        //else if(mapNode instanceof Project)return new MindMap("Map"+new Random().nextInt(100), mapNode);
            else if(mapNode instanceof MindMap)return new ElementFactory().createNode("E"+new Random().nextInt(100), mapNode);
            //else if(mapNode instanceof MindMap)return new Element("E"+new Random().nextInt(100), mapNode);
        return null;
    }

    @Override
    public MapTreeItem getSelectedNode() {
        MapTreeItem tree = (MapTreeItem) treeView.getLastSelectedPathComponent();
        //treeView.;
        return tree;
    }

    @Override
    public void deleteChild(MapTreeItem child) {
        if(child == null) return;
        //if(!(child.getMapNode() instanceof MapNodeComposite))return;
        if(child.getMapNode() instanceof  ProjectExplorer)return;
        if(child.getParent() == null) return;

        //((MapNodeComposite)((MapTreeItem)(child.getParent())).getMapNode()).removeChild(child.getMapNode());
        ((MapTreeItem)(child.getParent())).remove(child);

        child.removeFromParent();


        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
        
    }

    public void refreshTree(){
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}

package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.tree.view.MapTreeView;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
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

        MapNode chiled = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(chiled));
        ((MapNodeComposite)parent.getMapNode()).addChild(chiled);
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    private MapNode createChild(MapNode mapNode) {
        if(mapNode instanceof ProjectExplorer)return new Project("Project" + new Random().nextInt(100), mapNode);
        return null;
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }
}

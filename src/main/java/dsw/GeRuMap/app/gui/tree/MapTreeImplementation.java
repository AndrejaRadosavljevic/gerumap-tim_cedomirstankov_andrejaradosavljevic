package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.tree.model.MapTreeModel;
import dsw.GeRuMap.app.gui.tree.view.MapTreeView;
import dsw.GeRuMap.app.mapRepository.command.CommandManager;
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
import lombok.Setter;

import javax.swing.*;

import java.util.Random;



@Getter
@Setter
public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private MapTreeModel treeModel;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MapTreeModel(root);
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
        refreshTree();


    }

    private MapNode createChild(MapNode mapNode) {
        if(mapNode instanceof ProjectExplorer)return new ProjectFactory().createNode("Project" + new Random().nextInt(100), mapNode);
        else if(mapNode instanceof Project){
            int i = ((Project)mapNode).getIterator();
            int j=1;
            while(((Project)mapNode).getChildByName("Map"+j)!=null)j++;


            return new MindMapFactory().createNode("Map"+j, mapNode);
        }
            else if(mapNode instanceof MindMap)return new ElementFactory().createNode("E"+new Random().nextInt(100), mapNode);
        return null;
    }

    @Override
    public MapTreeItem getSelectedNode() {
        MapTreeItem tree = (MapTreeItem) treeView.getLastSelectedPathComponent();
        return tree;
    }

    @Override
    public void deselect() {
        treeView.clearSelection();
    }

    @Override
    public void deleteChild(MapTreeItem child) {
        if(child == null) return;
        if(child.getMapNode() instanceof  ProjectExplorer)return;
        if(child.getParent() == null) return;

        ((MapNodeComposite)((MapTreeItem)(child.getParent())).getMapNode()).removeChild(child.getMapNode());
        ((MapTreeItem)(child.getParent())).remove(child);

        child.removeFromParent();


        treeView.expandPath(treeView.getSelectionPath());
        refreshTree();
        deselect();
    }

    @Override
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);
        treeModel.getRoot().add(loadedProject);

        for(MapNode m: node.getChildren()){
            ((MindMap)m).setCommandManager(new CommandManager());
                for(MapNode e:((MindMap) m).getChildren()){
                    e.setParent(m);
            }
            MapTreeItem mapTreeItem = new MapTreeItem(m);
            loadedProject.add(mapTreeItem);
        }

        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        mapNode.addChild(node);



        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public void saveSelectedMap() {
        if(getSelectedNode() == null)return;
        MapNode node = getSelectedNode().getMapNode();
        if(node instanceof MindMap){
            ApplicationFramework.getInstance().getSerializer().saveTemplate((MindMap) node);
        }
    }

    public void refreshTree(){
        SwingUtilities.updateComponentTreeUI(treeView);
     }

}

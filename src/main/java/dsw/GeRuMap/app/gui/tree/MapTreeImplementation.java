package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
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
import lombok.Setter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Getter
@Setter
public class MapTreeImplementation implements MapTree, IPublisher {

    private static MapTreeImplementation instance;
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    private List<ISubscriber> subscribers;

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

        notifySubscriber(1);


        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite)parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        refreshTree();


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
    public void deselect() {
        treeView.clearSelection();
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
        refreshTree();


    }

    public void refreshTree(){
        SwingUtilities.updateComponentTreeUI(treeView);

        MapTreeImplementation.getInstance().notifySubscriber(null);
    }



    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null)subscribers = new ArrayList<>();
        if(!(subscribers.contains(sub)))subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if (subscribers==null)return;
        if(subscribers.isEmpty())return;
        for(ISubscriber sub:subscribers){
            sub.update(notification);
        }
    }



    public static MapTreeImplementation getInstance() {
        if(instance == null)instance = new MapTreeImplementation();
        return instance;
    }
}

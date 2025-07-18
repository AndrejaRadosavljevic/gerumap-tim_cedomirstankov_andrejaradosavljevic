package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.tree.view.MapTreeView;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

import java.util.List;

public interface MapTree{

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();

    void deselect();

    void deleteChild(MapTreeItem selected);

    void loadProject(Project node);


    void saveSelectedMap();
}

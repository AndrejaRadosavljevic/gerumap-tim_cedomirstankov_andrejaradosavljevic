package dsw.GeRuMap.app.gui.tree;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.tree.view.MapTreeView;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

public class MapTreeImplementation implements MapTree{
    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        return null;
    }

    @Override
    public void addChild(MapTreeItem parent) {

    }

    @Override
    public MapTreeItem getSelectedNode() {
        return null;
    }
}

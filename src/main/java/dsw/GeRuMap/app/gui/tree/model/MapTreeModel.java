package dsw.GeRuMap.app.gui.tree.model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MapTreeModel extends DefaultTreeModel {

    public MapTreeModel(TreeNode root) {
        super(root);
    }

    @Override
    public MapTreeItem getRoot() {
        MapTreeItem root = (MapTreeItem) super.getRoot();
        return root;
    }

}

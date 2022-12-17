package dsw.GeRuMap.app.gui.tree.controller;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener{
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path=e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem)path.getLastPathComponent();


    }


}

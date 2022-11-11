package dsw.GeRuMap.app.gui.tree.controller;

import dsw.GeRuMap.app.gui.tree.MapTreeImplementation;
import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;

public class MapTreeSelectionListener implements TreeSelectionListener{
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path=e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem)path.getLastPathComponent();


        System.out.println("Selektovan cvor:"+treeItemSelected.getMapNode().getName());
        System.out.println("getPath: "+e.getPath());
    }


}

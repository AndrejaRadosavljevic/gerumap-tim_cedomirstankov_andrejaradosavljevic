package dsw.GeRuMap.app.gui.tree.view;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

@NoArgsConstructor
public class MapTreeCellRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus){

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        URL imageURL = null;

        if(((MapTreeItem)value).getMapNode() instanceof ProjectExplorer){
            imageURL = getClass().getResource("/images/tdiagram.gif");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof Project){
               imageURL= getClass().getResource("/images/tproject.gif");
        }

        Icon icon=null;
        if(imageURL!=null)
            icon=new ImageIcon(imageURL);
        setIcon(icon);

        return this;

    }
}

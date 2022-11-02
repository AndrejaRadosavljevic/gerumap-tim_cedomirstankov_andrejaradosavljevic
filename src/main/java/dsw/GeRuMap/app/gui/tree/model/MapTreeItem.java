package dsw.GeRuMap.app.gui.tree.model;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public  MapTreeItem(MapNode nodeModel){
        mapNode = nodeModel;
    }


    @Override
    public String toString() {
        return mapNode.getName();
    }

    public MapNode getMapNode() {
        return mapNode;
    }

    public void setName(String name){}
    //Nisam siguran zasta ce nam ovo

}

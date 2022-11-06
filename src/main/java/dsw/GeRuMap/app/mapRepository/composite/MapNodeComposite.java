package dsw.GeRuMap.app.mapRepository.composite;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public abstract class MapNodeComposite extends MapNode {
    private List<MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children=new ArrayList<>();
    }

    public MapNodeComposite(String name, MapNode parent, List<MapNode> children){
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(MapNode child);
    public MapNode getChildByName(String name) {
        for (MapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }


    public void removeChild(MapNode child) {
        children.remove(child);
    }
}

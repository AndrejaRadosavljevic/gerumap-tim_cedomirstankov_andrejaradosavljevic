package dsw.GeRuMap.app.mapRepository.composite;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;

import java.util.ArrayList;
import java.util.List;

public class MapNodeComposite extends MapNode {
    private List<MapNode> children;

    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children=new ArrayList<>();
    }

    public void addChiled(MapNode chiled) {
        if(!(children instanceof List<MapNode>))children = new ArrayList<>();
        children.add(chiled);
    }
}

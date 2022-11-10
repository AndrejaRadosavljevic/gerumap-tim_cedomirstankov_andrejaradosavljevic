package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

public class MindMapFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {
        MapNode mindMap = new MindMap(name,parent);
        return mindMap;
    }
}

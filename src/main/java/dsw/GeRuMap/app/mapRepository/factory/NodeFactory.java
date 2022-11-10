package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;

public abstract class NodeFactory {

    public abstract MapNode createNode(String name, MapNode parent);
}

package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;

public class ElementFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {
        MapNode element=new Element(name,parent);
        return element;
    }
}

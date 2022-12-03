package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;

import java.awt.*;

public class MindMap extends MapNodeComposite {
    private boolean isTemplate;
    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Element){
            if (!this.getChildren().contains(child)){
                child.setParent(this);
                this.getChildren().add(child);
            }
        }
    }
    public Element getChildOnLocation(Point x){
        for(MapNode e : getChildren()){
            if(((PojamElement)e).hasPoint(x)){
                System.out.println(e.getName());
                return (Element) e;
            }
        }
        System.out.println("nista");
        return null;
    }
}

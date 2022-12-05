package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

                System.out.println(child.getName());
            }
        }
    }
    ///// ovde mora da se doradi tako da moze da se selektuje i veza

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

    @Override
    public void removeChild(MapNode child) {
        List<MapNode> visak = new ArrayList<>();
        for(MapNode e:getChildren()){
            if(e instanceof VezaElement){
                if(((VezaElement)e).getPE1().equals(child)||((VezaElement)e).getPE2().equals(child))visak.add(e);
            }
        }
        for(MapNode e: visak)removeChild(e);
        super.removeChild(child);
    }
}

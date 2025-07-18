package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.mapRepository.command.CommandManager;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class MindMap extends MapNodeComposite implements IPublisher {


    @ToString.Exclude
    private transient CommandManager commandManager;

    @ToString.Exclude
    private transient List<ISubscriber> subscribers;
    public MindMap(String name, MapNode parent) {
        super(name, parent);
        commandManager = new CommandManager();

    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Element){
            if (!this.getChildren().contains(child)){
                child.setParent(this);
                this.getChildren().add(child);
            }
        }
        notifySubscriber(this);
    }

    public Element getChildOnLocation(Point x){
        for(MapNode e : getChildren()){
            if(e instanceof PojamElement){
                if(((PojamElement)e).hasPoint(x)){
                    return (Element) e;
                }
            }
            else{
                if(((VezaElement)e).hasPoint(x)){
                    return  (Element) e;
                }
            }

        }
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
        notifySubscriber(this);
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null)subscribers = new ArrayList<>();
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        for(ISubscriber s: subscribers)s.update(notification);
    }
}

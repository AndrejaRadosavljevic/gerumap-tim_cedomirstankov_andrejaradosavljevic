package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Project extends MapNodeComposite implements IPublisher {

    private String autor;

    public Project(String name, MapNode parent) {
        super(name, parent);
        autor="Autor";
        addSubscriber(MainFrame.getInstance().getTabPanel());
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof MindMap){
            if (!this.getChildren().contains(child)){
                this.getChildren().add(child);
            }
        }
    }




    private List<ISubscriber> subscribers;
    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null)subscribers = new ArrayList<>();
        if(!(subscribers.contains(sub)))subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if (subscribers==null)return;
        if(subscribers.isEmpty())return;
        for(ISubscriber sub:subscribers){
            sub.update(notification);
        }
    }



}

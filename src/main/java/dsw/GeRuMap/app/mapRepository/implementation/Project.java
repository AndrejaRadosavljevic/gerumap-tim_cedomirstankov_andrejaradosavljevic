package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project extends MapNodeComposite {

    private String autor;

    public Project(String name, MapNode parent) {
        super(name, parent);
        autor="Autor";
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null &&  child instanceof Project){
            MindMap mindMap = (MindMap) child;
            if (!this.getChildren().contains(mindMap)){
                this.getChildren().add(mindMap);
            }
        }
    }
}

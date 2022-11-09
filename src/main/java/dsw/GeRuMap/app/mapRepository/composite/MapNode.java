package dsw.GeRuMap.app.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter

public abstract class MapNode {
    public String name;
    @ToString.Exclude
    private MapNode parent;

    private String author;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }



    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof MapNode){
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
}

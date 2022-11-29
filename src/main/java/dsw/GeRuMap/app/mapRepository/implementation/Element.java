package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element extends MapNode {
    private int x, y;
    private int width, length;

    private int lineWidth;
    private int color;

    public Element(String name, MapNode parent) {
        super(name, parent);
    }
}

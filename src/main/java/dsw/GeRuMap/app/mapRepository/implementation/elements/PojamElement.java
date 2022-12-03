package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class PojamElement extends Element {

    private String text;
    private Dimension size;
    private Point position;

    public PojamElement(String name, MapNode parent,Stroke stroke,Paint paint,Point position,Dimension size) {
        super(name, parent,stroke,paint);
        this.position=position;
        this.size=size;
    }

    public boolean hasPoint(Point x) {
        if(x.x >= position.x && x.x <= position.x+size.width &&x.y >= position.y && x.y <= position.y+size.height)
            return true;
        return false;
    }
}

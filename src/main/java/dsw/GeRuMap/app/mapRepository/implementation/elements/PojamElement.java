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

    private boolean isSelected;

    public PojamElement(String name, MapNode parent,Stroke stroke,Paint paint,Point position,Dimension size) {
        super(name, parent,stroke,paint);
        this.position=position;
        this.size=size;
        this.isSelected=false;
    }

    public boolean hasPoint(Point x) {
        if(x.x*getScale() >= position.x && x.x*getScale() <= position.x+size.width &&x.y*getScale() >= position.y && x.y*getScale() <= position.y+size.height)
            return true;
        return false;
    }
}

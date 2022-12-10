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
        if(x.x >= position.x*getScale() && x.x <= (position.x+size.width)*getScale() &&x.y >= position.y*getScale() && x.y <= (position.y+size.height)*getScale())
            return true;
        return false;
    }
}

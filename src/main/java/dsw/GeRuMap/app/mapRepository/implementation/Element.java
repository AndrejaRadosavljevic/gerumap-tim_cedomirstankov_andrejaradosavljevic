package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.painters.ElementPainter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {

    private Stroke stroke;
    private Paint paint;

    //private String name;
    //private String description;

    private ElementPainter elementPainter;

    public Element(String name, MapNode parent,Stroke stroke, Paint paint){
        super(name,parent);
        this.stroke = stroke;
        this.paint = paint;
    }

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public ElementPainter getPainter() {
        return elementPainter;
    }
}

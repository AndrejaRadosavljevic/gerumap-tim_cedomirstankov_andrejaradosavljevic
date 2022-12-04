package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.painters.ElementPainter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {

    protected Stroke stroke;
    protected Paint paint;

    private int pbr ;
    private static int br = 0;

    //private String name;
    //private String description;


    public Element(String name, MapNode parent,Stroke stroke, Paint paint){
        super(name,parent);
        this.stroke = stroke;
        this.paint = paint;
        pbr = br;
        br++;
    }

    public Element(String name, MapNode parent) {
        super(name, parent);
        stroke = new BasicStroke(5);
        paint = Color.BLACK;
    }


}

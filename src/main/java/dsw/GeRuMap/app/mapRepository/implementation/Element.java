package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode implements ISubscriber {

    protected Stroke stroke;
    protected Paint paint;
    private double scale;
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

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(pbr == ((Element)obj).pbr)return true;
            else return false;
        }
        return false;
    }

    @Override
    public void update(Object notification) {
        scale =( (MapTab)notification).getScale();
    }
}

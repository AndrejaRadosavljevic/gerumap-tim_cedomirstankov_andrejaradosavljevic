package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;

import java.awt.*;

public abstract class DiagramDevice extends Element {

    protected Dimension size;
    protected Point position;




    public DiagramDevice(String name, MapNode parent, Point position, Dimension size, Stroke stroke, Paint paint){
        super(name,parent,stroke, paint);
        this.size = size;
        this.position = position;
    }




    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }


    public boolean hasPoint(Point x) {
        if(x.x >= position.x && x.x <= position.x+size.width &&x.y >= position.y && x.y <= position.y+size.height)return true;
        return false;
    }
}
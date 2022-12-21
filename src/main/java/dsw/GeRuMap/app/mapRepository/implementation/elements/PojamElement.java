package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
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
        Point p = new Point((int) (position.x/getScale()), (int) (position.y/getScale()));
        this.position=position;
        this.size=size;
        this.isSelected=false;
    }

    public boolean hasPoint(Point x) {
        if(x.x >= (position.x)*getScale() && x.x <= (position.x+size.width)*getScale() &&x.y >= (position.y)*getScale() && x.y <= (position.y+size.height)*getScale())
            return true;
        return false;
    }


    public boolean isWithinPoints(Point a, Point b){
        return a.x<= position.x*getScale() &&  (position.x+size.width)*getScale()<=b.x &&  a.y<= position.y*getScale() &&  (position.y+size.height)*getScale()<=b.y;
    }

    public Rectangle pravougaonik() {
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds((int) (position.x*getScale()), (int) (position.y*getScale()), (int) (size.width*getScale()), (int) (size.height*getScale()));
        return rectangle;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(getPbr() == ((Element)obj).getPbr())return true;
            else return false;
        }
        return false;
    }

    public Point getCurentPosition() {
        return new Point((int) (position.x*getScale()), (int) (position.y*getScale()));
    }
    public Dimension getCurentDimensions(){
        return new Dimension((int) (size.width*getScale()), (int) (size.height*getScale()));
    }

    public void movePoint(double h, double w){
        System.out.println(h+"IIIIIIIII"+w);
        position.x+=h;
        position.y+=w;
        ((MindMap)getParent()).notifySubscriber(getParent());
    }
}

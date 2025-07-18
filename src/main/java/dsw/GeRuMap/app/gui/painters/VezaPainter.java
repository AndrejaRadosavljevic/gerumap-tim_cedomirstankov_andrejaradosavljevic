package dsw.GeRuMap.app.gui.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.VezaElement;
import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter
public class VezaPainter extends ElementPainter{
    private Shape shape;


    public VezaPainter(Element element) {
        super(element);
        changeShape(element);
    }


    @Override
    public void paint(Graphics2D g, Element element) {
        g.setPaint(Color.BLACK);

        g.setStroke(new BasicStroke(element.getDebljina()));
        g.draw(getShape());
        g.setPaint(new ColorUIResource(element.getBoja()));
        g.fill(getShape());

    }

    public void changeShape(Element element) {
        float x1=(float) ((VezaElement) element).getPE1().getPosition().getX();
        float x2=(float) ((VezaElement) element).getPE2().getPosition().getX();
        float y1=(float) ((VezaElement) element).getPE1().getPosition().getY();
        float y2=(float) ((VezaElement) element).getPE2().getPosition().getY();

        x1= (float) (x1+((VezaElement) element).getPE1().getSize().getWidth()/2);
        x2= (float) (x2+((VezaElement) element).getPE2().getSize().getWidth()/2);
        y1= (float) (y1+((VezaElement) element).getPE1().getSize().getHeight()/2);
        y2= (float) (y2+((VezaElement) element).getPE2().getSize().getHeight()/2);


        shape=new Line2D.Float(x1,y1,x2,y2);
    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }

    public void setElement(Element element){
        this.element = element;
        changeShape(element);
    }
    public Element getElement(){
        return element;
    }

    public boolean contains(Point x) {

        float x1=(float) ((VezaElement) element).getPE1().getCurentPosition().getX();
        float x2=(float) ((VezaElement) element).getPE2().getCurentPosition().getX();
        float y1=(float) ((VezaElement) element).getPE1().getCurentPosition().getY();
        float y2=(float) ((VezaElement) element).getPE2().getCurentPosition().getY();

        x1= (float) (x1+((VezaElement) element).getPE1().getCurentDimensions().getWidth()/2);
        x2= (float) (x2+((VezaElement) element).getPE2().getCurentDimensions().getWidth()/2);
        y1= (float) (y1+((VezaElement) element).getPE1().getCurentDimensions().getHeight()/2);
        y2= (float) (y2+((VezaElement) element).getPE2().getCurentDimensions().getHeight()/2);




        Shape s=new Line2D.Float(x1,y1,x2,y2);


        if(s.getBounds().contains(x))return true;
        return false;
    }
}
package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;

@Getter
@Setter
public class PojamPainter extends ElementPainter{

    private Shape shape;


    public PojamPainter(Element element) {
        super(element);
        changeShape(element);
    }

    public void paint(Graphics2D g, Element element){

        g.setPaint(element.getPaint());

        g.setStroke(element.getStroke());
        g.draw(getShape());
        g.setPaint(element.getPaint());

        if (element instanceof PojamElement){
            FontMetrics fm = g.getFontMetrics();
            g.setPaint(Color.BLACK);
            PojamElement device= (PojamElement) element;
            int sw=fm.stringWidth(device.getName());
            g.drawString(device.getName(), (int)device.getPosition().getX()+(int)device.getSize().getWidth()/2-sw/2,
                    (int)device.getPosition().getY()+(int)device.getSize().getHeight()/2);
        }

    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }

    public void changeShape(Element element){
        shape=new Ellipse2D.Float((float) ((PojamElement)element).getPosition().getX(), (float) ((PojamElement)element).getPosition().getY(), ((float) ((PojamElement)element).getSize().getWidth()), ((float) ((PojamElement)element).getSize().getHeight()));
    }

    public void setElement(Element element){
        this.element=element;
        changeShape(element);
    }
}

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

        g.setPaint(Color.RED);

        g.setStroke(element.getStroke());
        g.draw(getShape());
        g.setPaint(element.getPaint());

        g.fill(getShape());

        if (element instanceof PojamElement){
            g.setPaint(Color.BLACK);
            PojamElement device= (PojamElement) element;
            g.drawString(device.getName(), (int)device.getPosition().getX()+10,
                    (int)device.getPosition().getY()+10);
        }

//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        BasicStroke stroke=new BasicStroke(5F);
//        g2.setStroke(stroke);
//        Ellipse2D.Float ln=new
//                Ellipse2D.Float(0F,0F,250F,230F);
//        g2.draw(ln);


    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }

    public void changeShape(Element element){
        shape=new Ellipse2D.Float((float) ((PojamElement)element).getSize().getHeight(), (float) ((PojamElement)element).getSize().getWidth(), (float) ((PojamElement)element).getPosition().getX(), (float) ((PojamElement)element).getPosition().getY());
    }

    public void setElement(Element element){
        this.element=element;
        changeShape(element);
    }
}

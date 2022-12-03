package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class PojamPainter extends ElementPainter{

    private Shape shape;

    public PojamPainter(Element element) {
        super(element);
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


    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
}

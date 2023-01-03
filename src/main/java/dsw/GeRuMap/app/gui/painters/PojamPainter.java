package dsw.GeRuMap.app.gui.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.css.RGBColor;

import javax.swing.plaf.ColorUIResource;
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

        g.setPaint(Color.WHITE);
        g.fill(getShape());
        g.setPaint(new ColorUIResource(element.getBoja()));
        g.setStroke(new BasicStroke(element.getDebljina()));
        g.draw(getShape());
        if(((PojamElement)element).isSelected()){
            g.setPaint(Color.GRAY);
            g.fill(getShape());
        }
        g.setPaint(new ColorUIResource(element.getBoja()));

        if (element instanceof PojamElement){
            FontMetrics fm = g.getFontMetrics();
            g.setPaint(Color.BLACK);
            PojamElement device= (PojamElement) element;
            int sw=fm.stringWidth(device.getName());
            if(((PojamElement)element).isCentered()){
                g.setFont(new Font("default", Font.BOLD, fm.getFont().getSize()));
            }else{
                g.setFont(new Font("default", Font.PLAIN, fm.getFont().getSize()));
            }
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

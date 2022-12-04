package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter {

    Element element;
    public ElementPainter(Element element) {
        this.element=element;
    }

    public abstract void paint(Graphics2D g, Element element);

    public abstract boolean elementAt(Element element, Point pos);


}

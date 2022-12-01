package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;

import java.awt.*;

public abstract class ElementPainter {

    public ElementPainter(Element element) {	}

    public abstract void paint(Graphics2D g, Element element);

    public abstract boolean elementAt(Element element, Point pos);


}

package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.awt.*;

public class VezaPainter extends ElementPainter{

    private VezaElement element;

    public VezaPainter(Element element) {
        super(element);
    }


    @Override
    public void paint(Graphics2D g, Element element) {

    }

    @Override
    public boolean elementAt(Element element, Point pos) {
        return false;
    }
}

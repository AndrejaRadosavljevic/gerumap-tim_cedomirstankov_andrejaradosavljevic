package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.gui.painters.VezaPainter;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.Position;
import java.awt.*;

@Getter
@Setter
public class VezaElement extends Element {

    private PojamElement pE1, pE2;

    public VezaElement(String name, MapNode parent,PojamElement pE1, PojamElement pE2) {
        super(name, parent);
        this.pE1 = pE1;
        this.pE2 = pE2;

    }
    public boolean hasPoint(Point x) {
        VezaPainter vp = new VezaPainter(this);


        if(vp.contains(x))return true;
        return false;
    }

}

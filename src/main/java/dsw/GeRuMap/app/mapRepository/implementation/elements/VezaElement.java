package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VezaElement extends Element {

    private PojamElement pE1, pE2;

    public VezaElement(String name, MapNode parent,PojamElement pE1, PojamElement pE2) {
        super(name, parent);
        this.pE1 = pE1;
        this.pE2 = pE2;

    }
}

package dsw.GeRuMap.app.mapRepository.implementation.elements;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VezaElement extends Element {

    private PojamElement pE1, pE2;

    public VezaElement(String name, MapNode parent) {
        super(name, parent);
        //doradi
    }
}

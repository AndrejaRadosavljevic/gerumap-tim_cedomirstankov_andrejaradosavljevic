package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name, MapNode parent) {

        super(name, parent);
    }

    public ProjectExplorer(String name) {
        super(name,null);
    }


}

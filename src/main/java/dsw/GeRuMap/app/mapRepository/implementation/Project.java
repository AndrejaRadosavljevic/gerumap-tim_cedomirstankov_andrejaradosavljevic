package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;

public class Project extends MapNodeComposite {
    private String ime;
    private  String autor;
    private String folderPath;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }
}

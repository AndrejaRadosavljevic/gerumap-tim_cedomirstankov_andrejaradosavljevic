package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {
        MapNode project= new Project(name,parent);
        return project;
    }
}

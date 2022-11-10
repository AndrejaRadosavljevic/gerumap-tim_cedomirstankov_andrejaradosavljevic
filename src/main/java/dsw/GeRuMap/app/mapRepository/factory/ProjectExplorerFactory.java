package dsw.GeRuMap.app.mapRepository.factory;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

public class ProjectExplorerFactory extends NodeFactory{

    @Override
    public MapNode createNode(String name,MapNode parent) {
        MapNode projectExplorer = new ProjectExplorer(name);
        return projectExplorer;
    }
}

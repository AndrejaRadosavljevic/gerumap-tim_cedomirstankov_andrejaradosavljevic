package dsw.GeRuMap.app.mapRepository;

import dsw.GeRuMap.app.core.MapRepository;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.factory.ProjectExplorerFactory;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl(){
        //projectExplorer=new ProjectExplorer("My Project Explorer");
        projectExplorer= (ProjectExplorer) new ProjectExplorerFactory().createNode("My Project Explorer",null);
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    //?????????????????
    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        child.setParent(parent);
        if(parent == projectExplorer)projectExplorer.addChild(child);
        else ((MapNodeComposite)projectExplorer.getChildByName(parent.name)).addChild(child);
    }
}

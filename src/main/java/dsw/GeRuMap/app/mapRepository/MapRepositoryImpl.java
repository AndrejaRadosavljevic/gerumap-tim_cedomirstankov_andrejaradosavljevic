package dsw.GeRuMap.app.mapRepository;

import dsw.GeRuMap.app.core.MapRepository;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.composite.MapNodeComposite;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {


    @Override
    public ProjectExplorer getProjectExplorer() {
        return null;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode chiled) {

    }
}

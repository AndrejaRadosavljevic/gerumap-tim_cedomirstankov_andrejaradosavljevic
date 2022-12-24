package dsw.GeRuMap.app.core;

import com.google.gson.JsonArray;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.io.File;
import java.util.List;

public interface Serializer {
    Project loadProject(File file);
    List<MapNode> loadMindMaps(JsonArray jsonMaps);
    List<MapNode> loadElements(JsonArray jsonElements);

    void saveProject(Project node);
    void saveMap(MindMap node);
    void saveTemplate(MindMap node);
}

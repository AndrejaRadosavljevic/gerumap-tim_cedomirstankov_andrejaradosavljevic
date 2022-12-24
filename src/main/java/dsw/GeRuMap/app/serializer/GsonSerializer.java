package dsw.GeRuMap.app.serializer;

import com.google.gson.*;
import dsw.GeRuMap.app.core.Serializer;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonSerializer implements Serializer {

    private final Gson gson = new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            FileReader reader = new FileReader(file);
            Project project =  gson.fromJson(fileReader, Project.class);
            JsonObject object = JsonParser.parseReader(reader).getAsJsonObject();
            project.setChildren(loadMindMaps((JsonArray) object.get("children")));
            return project;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MapNode> loadMindMaps(JsonArray jsonMaps) {
        List<MapNode> maps = new ArrayList<>();
        for (JsonElement map : jsonMaps) {
            JsonObject m = map.getAsJsonObject();
            MindMap mindMap = gson.fromJson(map.toString(), MindMap.class);

            JsonArray elements = (JsonArray) m.get("children");

            List<MapNode> e = loadElements(elements);

            mindMap.setChildren(e);
        }
        return maps;
    }
        @Override
        public List<MapNode> loadElements(JsonArray jsonElements) {
            List<MapNode> elements = new ArrayList<>();
            for(JsonElement element:jsonElements){
                if(element.getAsJsonObject().has("pE1")){
                    elements.add(gson.fromJson(element.toString(), VezaElement.class));
                } else {
                    elements.add(gson.fromJson(element.toString(), PojamElement.class));
                }
            }

            return elements;
        }


        @Override
        public void saveProject(Project node) {
            try (FileWriter writer = new FileWriter(node.getPath())) {
                gson.toJson(node, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void saveMap(MindMap node) {

        }

        @Override
        public void saveTemplate(MindMap node) {

        }

}

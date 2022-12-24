package dsw.GeRuMap.app.serializer;

import com.google.gson.Gson;
import dsw.GeRuMap.app.core.Serializer;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;

import java.io.*;

public class GsonSerializer implements Serializer {

    private final Gson gson = new Gson();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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

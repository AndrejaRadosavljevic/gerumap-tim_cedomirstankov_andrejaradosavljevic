package dsw.GeRuMap.app.serializer;

import com.google.gson.*;
import dsw.GeRuMap.app.core.Serializer;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonSerializer implements Serializer {

    private final Gson gson=new GsonBuilder().registerTypeAdapter(MapNode.class, new AbstractElementAdapter()).create();

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Project project =  gson.fromJson(fileReader, Project.class);
            for(MapNode map: project.getChildren()){
                map.setParent(project);
                for(MapNode e:((MindMap)map).getChildren()){
                    ((Element)e).increment();
                    if(e instanceof VezaElement){
                        e.setParent(map);
                        for(MapNode p:((MindMap)map).getChildren() ){
                            if(p instanceof PojamElement){
                                if(((VezaElement) e).getPE1().getPosition().equals(((PojamElement)p).getPosition()))
                                    ((VezaElement) e).setPE1((PojamElement) p);
                                if(((VezaElement) e).getPE2().getPosition().equals(((PojamElement)p).getPosition()))
                                    ((VezaElement) e).setPE2((PojamElement) p);
                                p.setParent(map);
                            }
                        }
                    }
                }
            }
            return project;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
    public MindMap loadTemplate(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            MindMap map =  gson.fromJson(fileReader, MindMap.class);
            for(MapNode e:map.getChildren()){
                ((Element)e).increment();
                if(e instanceof VezaElement){
                    e.setParent(map);
                    for(MapNode p:map.getChildren() ){
                        if(p instanceof PojamElement){
                            if(((VezaElement) e).getPE1().getPosition().equals(((PojamElement)p).getPosition()))
                                ((VezaElement) e).setPE1((PojamElement) p);
                            if(((VezaElement) e).getPE2().getPosition().equals(((PojamElement)p).getPosition()))
                                ((VezaElement) e).setPE2((PojamElement) p);
                        p.setParent(map);
                        }
                    }
                }
            }

            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
        public void saveTemplate(MindMap node) {
            try (FileWriter fileWriter = new FileWriter("sabloni/"+node.getName())){
                gson.toJson(node,fileWriter);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}

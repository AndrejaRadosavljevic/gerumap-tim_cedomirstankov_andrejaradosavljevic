package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;
@Setter@Getter
public class MapView {
    private MindMap mindMap;
    private List<ElementPainter> painters;
    private Element selected;

    public MapView(MindMap map){
        mindMap = map;
        painters = new ArrayList<>();
        for(MapNode e: map.getChildren()){
            if(e instanceof PojamElement)painters.add(new PojamPainter((Element) e));
            else painters.add(new VezaPainter((Element) e));
        }
    }

    public  void removeChild(Point x){
        Element element = mindMap.getChildOnLocation(x);
        if(element==null)return;
        removeChild(element);
    }

    public void removeChild(Element element){
        mindMap.removeChild(element);
        updateList();
    }


    public void updateList(){
        painters.removeAll(painters);
        for(MapNode e: mindMap.getChildren()){
            if(e instanceof PojamElement)painters.add(new PojamPainter((Element) e));
            else painters.add(new VezaPainter((Element) e));
        }
    }


    public void addPainter(ElementPainter elementPainter) {
        painters.add(elementPainter);
        mindMap.addChild(elementPainter.element);
    }

    public void addPainter(Point x, Point y) {
    }
}

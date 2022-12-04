package dsw.GeRuMap.app.painters;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;
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
        removePainter(element);
        removeChild(element);
    }

    public void removeChild(Element element){
        mindMap.removeChild(element);
    }
    public void removePainter(Element element){
        ElementPainter elementPainter = null;
        int i =0;
        while(i<painters.size()){
            elementPainter = painters.get(i++);
            if(elementPainter.getElement() == element){
                painters.remove(elementPainter);
                i--;
            }

        }
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
        mindMap.addChild(elementPainter.getElement());
    }

    public void addPainter(Point x, Point y) {
        PojamElement p1 = (PojamElement) mindMap.getChildOnLocation(x);
        PojamElement p2 = (PojamElement) mindMap.getChildOnLocation(y);
        VezaElement vezaElement = new VezaElement("veza"+x+y,mindMap,p1,p2);
        addPainter(new VezaPainter(vezaElement));
    }
}

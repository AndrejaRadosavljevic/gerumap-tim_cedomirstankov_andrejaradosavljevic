package dsw.GeRuMap.app.gui.painters;

import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.elements.PojamElement;
import dsw.GeRuMap.app.mapRepository.implementation.elements.VezaElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
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
        updateList();
    }

    public void removeChild(Element element){
        mindMap.removeChild(element);
        updateList();
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

    public void addPainter(Element element) {
        mindMap.addChild(element);
        updateList();
    }

    public void addPainter(Point x, Point y) {
        Element p1 = mindMap.getChildOnLocation(x);
        Element p2 =  mindMap.getChildOnLocation(y);

        System.out.println(p1+" LLLLLL "+p2);
        if(p1 == null || p2 == null) return;
        if(p1 instanceof VezaElement || p2 instanceof VezaElement) return;
        if(p1.equals(p2)) return;
        
        VezaElement vezaElement = new VezaElement("veza("+x.x+","+x.y+","+y.x+","+y.y+")",mindMap,(PojamElement) p1,(PojamElement) p2);
        for(MapNode element:mindMap.getChildren()){
            if(element instanceof VezaElement){
                if(vezaElement.getPE1() ==((VezaElement) element).getPE1() && vezaElement.getPE2() ==((VezaElement) element).getPE2()){
                    System.out.println("ERROR");
                    return;
                }
                if(vezaElement.getPE1() ==((VezaElement) element).getPE2() && vezaElement.getPE2() ==((VezaElement) element).getPE1()){
                    System.out.println("ERROR");
                    return;
                }
            }
        }
        addPainter(vezaElement);
    }

    public  ElementPainter getPainter(Element element){
        for(ElementPainter elementPainter:painters){
            if(elementPainter.element.equals(element))return elementPainter;
        }
        return null;
    }

    public boolean containsElementOnPoint(Point x) {
        for(MapNode e:mindMap.getChildren()){
            if(e instanceof PojamElement){
                if(((PojamElement)e).hasPoint(x))return true;
            }
            else if(((VezaElement)e).hasPoint(x))return true;
        }
        return false;
    }
}

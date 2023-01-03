package dsw.GeRuMap.app.mapRepository.command.komande;

import dsw.GeRuMap.app.mapRepository.command.AbstractCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import java.util.List;

public class BrisiElementCommand extends AbstractCommand {

    private MindMap map;

    private List<Element> elements;


    public BrisiElementCommand(MindMap map, List<Element> elements){
        this.elements = elements;
        this.map = map;

    }

    @Override
    public void doCommand() {
        for(Element element: elements){
            map.removeChild(element);
        }
    }

    @Override
    public void undoCommand() {
        for(Element element: elements){
            map.addChild(element);
        }
    }


}

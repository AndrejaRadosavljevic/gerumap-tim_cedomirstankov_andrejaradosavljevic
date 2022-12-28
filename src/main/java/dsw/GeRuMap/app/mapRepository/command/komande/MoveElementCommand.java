package dsw.GeRuMap.app.mapRepository.command.komande;

import dsw.GeRuMap.app.mapRepository.command.AbstractCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.PojamElement;

import java.util.List;

public class MoveElementCommand extends AbstractCommand {

    private List<Element> elements;

    private double h;
    private double w;


    public MoveElementCommand(List<Element> elements, double h, double w) {
        this.elements = elements;
        double scale = elements.get(0).getScale();
        this.h = h/scale;
        this.w = w/scale;
    }

    @Override
    public void doCommand() {
        for(Element e:elements){
            if(e instanceof PojamElement){
                ((PojamElement) e).movePoint(-h,-w);
            }
        }

    }

    @Override
    public void undoCommand() {
        for(Element e:elements){
            if(e instanceof PojamElement){
                ((PojamElement) e).movePoint(h,w);
            }
        }
    }
}

package dsw.GeRuMap.app.gui.state.concrete;

import dsw.GeRuMap.app.gui.state.State;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.command.komande.MoveElementCommand;
import dsw.GeRuMap.app.mapRepository.implementation.Element;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveState implements State {

    private Point start, end=null;
    @Override
    public void doState(Point x) {
        start = x;
    }

    @Override
    public void doState(Point x, Point y) {
        double h = y.getX() - x.getX();
        double w = y.getY() - x.getY();

        List<Element> elements = ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getSelectedElements();


        if(elements.size()!=0){
            if(end !=null){
                MoveElementCommand command = new MoveElementCommand(new ArrayList<>(elements), start.getX() - end.getX(), start.getY() - end.getY());
                ((MindMap)elements.get(0).getParent()).getCommandManager().addCommand(command);
                end = null;
                return;
            }
            ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).moveSelected(h,w);
            return;
        }

        ((MapTab)MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).moveView(h,w);

    }

    public void setEnd(Point end) {
        this.end = end;
    }
}

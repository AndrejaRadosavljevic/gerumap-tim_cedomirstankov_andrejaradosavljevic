package dsw.GeRuMap.app.gui.tree.model;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;
import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

@Getter
@Setter
public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public  MapTreeItem(MapNode nodeModel){
        mapNode = nodeModel;

    }




    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name){
        this.mapNode.setName(name);
    }
    //Nisam siguran zasta ce nam ovo


}

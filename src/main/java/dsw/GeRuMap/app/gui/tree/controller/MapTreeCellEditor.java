package dsw.GeRuMap.app.gui.tree.controller;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.implementation.MindMap;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import dsw.GeRuMap.app.mapRepository.implementation.ProjectExplorer;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

@Getter
@Setter

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1){
        super(arg0,arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5){
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn=arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }


    @Override
    public boolean isCellEditable(EventObject arg0) {
        if(arg0 instanceof MouseEvent){
            if(((MouseEvent)arg0).getClickCount()==3){
                if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof ProjectExplorer)return false;
                    return true;
            }

            if(((MouseEvent)arg0).getClickCount()==2){
                MapTreeItem m = MainFrame.getInstance().getMapTree().getSelectedNode();
                if(m.getMapNode() instanceof Project){
                    ((Project)m.getMapNode()).addSubscriber(MainFrame.getInstance().getTabPanel());
                    ((Project)m.getMapNode()).notifySubscriber(m);
                }
                return false;
            }
        }


        return false;


    }





    public void actionPerformed(ActionEvent e){
        if(!(clickedOn instanceof MapTreeItem))
            return;

        MapTreeItem clicked = (MapTreeItem) clickedOn;
        clicked.setName(e.getActionCommand());
    }
}

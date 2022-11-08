package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame {

    private static InfoFrame instance;

    private InfoFrame(){
    }

    public static InfoFrame getInstance(){
        if(instance==null){
            instance = new InfoFrame();
            instance.initialise();
        }
        return instance;
    }

    private void initialise() {
        initialiseGUI();
    }

    private void initialiseGUI(){
        JTextField textField = new JTextField("GeRuMap su osmislili i napravili :");
        JTextField cedaSlika = new JTextField();
        //cedaSlika.add
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationRelativeTo(null);

        JPanel desktop = new JPanel();


    }


}

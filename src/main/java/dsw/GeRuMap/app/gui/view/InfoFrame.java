package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.tree.model.MapTreeItem;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        JPanel panel = new JPanel(new GridLayout(3,1,5,5));

        JLabel label1 = new JLabel("GeRuMap su osmislili i napravili:");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label1, 0);


        JLabel cedaLabel = new JLabel(new ImageIcon(getClass().getResource("/images/ceda.png")));
        JLabel andraLabel = new JLabel(new ImageIcon(getClass().getResource("/images/andra.png")));

        JLabel cedaTF = new JLabel("Cedomir Stankov");
        JLabel andraTF = new JLabel("Andreja Radosavljevic");

        JPanel cedaPanel = new JPanel();
        cedaPanel.add(cedaTF);
        cedaPanel.add(cedaLabel);

        JPanel andraPanel = new JPanel();
        andraPanel.add(andraTF);
        andraPanel.add(andraLabel);

        panel.add(cedaPanel,SwingConstants.CENTER, 1);
        panel.add(andraPanel,SwingConstants.CENTER, 2);

        add(panel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2,screenHeight/2);
        setLocationRelativeTo(null);

        JPanel desktop = new JPanel();


    }


}

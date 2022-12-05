package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.PodesiAction;
import dsw.GeRuMap.app.gui.controller.update.PotvrdiElementAction;

import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;

public class PodesavanjaFrame extends JFrame{
    private static PodesavanjaFrame instance;

    private JTextField textField1;
    private JTextField textField2;

    private JColorChooser colorChooser;
    private JButton button1;
    private JButton button2;
    private Color color;

    private  Point point;

    public PodesavanjaFrame(){
        initialise();
    }

    public void initialise(){
        initialiseGUI();
    }

    private void initialiseGUI(){

        JPanel panel = new JPanel(new GridLayout(4,1,5,5));

        JLabel label1 = new JLabel("Debljina linije");

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100,20));
        JPanel panel1 = new JPanel();
        panel1.add(label1);
        panel1.add(textField1);

        JLabel label2 = new JLabel("Text pojma");
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100,20));
        JPanel panel2 = new JPanel();
        panel2.add(label2);
        panel2.add(textField2);

        panel.add(panel1,0);
        panel.add(panel2,1);

        colorChooser = new JColorChooser(Color.BLACK);
        colorChooser.setVisible(true);
        colorChooser.setSelectionModel(new DefaultColorSelectionModel());

        panel.add(colorChooser,2);

        button1 = new JButton(new PodesiAction());
        button1.setText("Potvrdi");
        panel.add(button1);

        add(panel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth,screenHeight);
        setLocationRelativeTo(null);



    }

    public static PodesavanjaFrame getInstance(){
        if(instance == null) instance = new PodesavanjaFrame();
        return instance;
    }
}

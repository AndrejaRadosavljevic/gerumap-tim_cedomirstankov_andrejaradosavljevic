package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.PodesiAction;
import dsw.GeRuMap.app.gui.controller.update.PotvrdiElementAction;

import javax.swing.*;
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

        JLabel label1 = new JLabel("Text pojma");
        label1.setHorizontalAlignment(SwingConstants.CENTER);


        textField1=new JTextField("Uneti text unutar pojma");
        button1=new JButton("Potvrdi");

        JPanel panel1 = new JPanel();

        panel1.add(label1);
        panel1.add(textField1);

        panel.add(panel1,SwingConstants.CENTER,0);


        JPanel panel3=new JPanel();

        button1.addActionListener(new PodesiAction());
        panel3.add(button1);

        panel.add(panel3,SwingConstants.CENTER,1);


        //color = JColorChooser.showDialog(null,"Izaberite boju pocetnu boju",Color.BLACK);

        add(panel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4,screenHeight/4);
        setLocationRelativeTo(null);



    }

    public static PodesavanjaFrame getInstance(){
        if(instance == null) instance = new PodesavanjaFrame();
        return instance;
    }
}

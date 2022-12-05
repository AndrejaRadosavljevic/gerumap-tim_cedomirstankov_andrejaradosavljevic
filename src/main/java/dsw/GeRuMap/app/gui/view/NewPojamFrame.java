package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.PotvrdiElementAction;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class NewPojamFrame extends JFrame {
    private static NewPojamFrame instance;

    private JTextField textField1;

    private JColorChooser colorChooser;
    private JButton button1;
    private Color color;

    private  Point point;

    public NewPojamFrame(){
        initialise();
    }

    public void initialise(){
        initialiseGUI();
    }

    private void initialiseGUI(){

        JPanel panel = new JPanel(new GridLayout(4,1,5,5));

        JLabel label1 = new JLabel("Text pojma");
        label1.setHorizontalAlignment(SwingConstants.CENTER);


        textField1=new JTextField("Uneti tekst pojma");
        button1=new JButton("Potvrdi");

        JPanel panel1 = new JPanel();

        panel1.add(label1);
        panel1.add(textField1);

        panel.add(panel1,SwingConstants.CENTER,0);


        JPanel panel3=new JPanel();

        button1.addActionListener(new PotvrdiElementAction());
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

    public static NewPojamFrame getInstance(){
        if(instance == null) instance = new NewPojamFrame();
        return instance;
    }
}

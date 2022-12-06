package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.update.PodesiAction;
import dsw.GeRuMap.app.gui.controller.update.PotvrdiElementAction;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;
@Getter
@Setter
public class PodesavanjaFrame extends JDialog{

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
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


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

        button1 = new JButton("Potvrdi");
        button1.addActionListener(new PodesiAction(this));
        button1.setPreferredSize(new Dimension(200,50));

        JPanel panel3 = new JPanel();
        panel3.add(button1);
        panel.add(panel3);

        add(panel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2,screenHeight/4*3);
        setLocationRelativeTo(null);



    }
}

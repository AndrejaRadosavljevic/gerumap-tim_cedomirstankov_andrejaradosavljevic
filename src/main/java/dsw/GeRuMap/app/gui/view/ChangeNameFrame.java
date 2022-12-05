package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.controller.PotvrdiButtonAction;
import dsw.GeRuMap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class ChangeNameFrame extends JFrame{

    private static ChangeNameFrame instance;

    private JTextField textField1;
    private JTextField textField2;

    private JButton button1;

    public void initialise(){
        initialiseGUI();
    }

    private void initialiseGUI(){

        JPanel panel = new JPanel(new GridLayout(3,1,5,5));

        JLabel label1 = new JLabel("Unesite autora");
        JLabel label2=new JLabel("Unesite Ime Projekta");
        label1.setHorizontalAlignment(SwingConstants.CENTER);


        textField1=new JTextField(((Project)MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode()).getAutor());
        textField1.setPreferredSize(new Dimension(100,20));
        textField2=new JTextField(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode().getName());
        textField2.setPreferredSize(new Dimension(100,20));
        button1=new JButton("Potvrdi");

        JPanel panel1 = new JPanel();

        panel1.add(label1);
        panel1.add(textField1);

        panel.add(panel1,SwingConstants.CENTER,0);

        JPanel panel2 = new JPanel();

        panel2.add(label2);
        panel2.add(textField2);

        panel.add(panel2,SwingConstants.CENTER,1);

        JPanel panel3=new JPanel();

        button1.addActionListener(new PotvrdiButtonAction());
        panel3.add(button1);

        panel.add(panel3,SwingConstants.CENTER,2);

        add(panel);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/4,screenHeight/4);
        setLocationRelativeTo(null);

        JPanel desktop = new JPanel();


    }

    private ChangeNameFrame(){

    }

    public static ChangeNameFrame getInstance(){
        if(instance==null){
            instance = new ChangeNameFrame();
            instance.initialise();
        }
        return instance;
    }
}

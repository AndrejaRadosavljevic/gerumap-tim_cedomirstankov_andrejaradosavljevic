package dsw.GeRuMap.app.gui.view;

import dsw.GeRuMap.app.gui.messagegenerator.Message;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class PorukaFrame extends JOptionPane {
    private static PorukaFrame instance;
    private JFrame f = new JFrame();

    private PorukaFrame(){
    }

    public void prikaziPoruku(Message m){
        PorukaFrame.getInstance().setVisible(true);
        PorukaFrame.showMessageDialog(f,m.getContent(),"Error",JOptionPane.ERROR_MESSAGE);
    }

    public static PorukaFrame getInstance(){
        if(instance==null){
            instance = new PorukaFrame();
        }
        return instance;
    }
}

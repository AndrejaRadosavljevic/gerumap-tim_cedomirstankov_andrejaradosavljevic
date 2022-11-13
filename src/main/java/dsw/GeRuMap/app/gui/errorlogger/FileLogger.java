package dsw.GeRuMap.app.gui.errorlogger;

import dsw.GeRuMap.app.gui.messagegenerator.Message;
import dsw.GeRuMap.app.gui.view.MainFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ErrorLogger{

    private static FileLogger instance;
    File file = new File("src/main/resources/log.txt");

    @Override
    public void log() {

    }

    @Override
    public void update(Object notification) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file,true);
            fw.write(((Message)notification).getContent()+"\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void obrisi(){
        FileWriter fw =null;
        try {
            fw=new FileWriter(file);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static FileLogger getInstance(){
        if(instance==null){
            instance = new FileLogger();
        }
        return instance;
    }

}

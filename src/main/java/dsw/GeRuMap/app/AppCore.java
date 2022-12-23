package dsw.GeRuMap.app;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.core.MapRepository;
import dsw.GeRuMap.app.core.Serializer;
import dsw.GeRuMap.app.gui.SwingGui;
import dsw.GeRuMap.app.gui.errorlogger.ConsoleLogger;
import dsw.GeRuMap.app.gui.errorlogger.ErrorLogger;
import dsw.GeRuMap.app.gui.errorlogger.FileLogger;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import dsw.GeRuMap.app.serializer.GsonSerializer;

public class AppCore extends ApplicationFramework{

    private static AppCore instance;

    private AppCore(){

    }

    public static AppCore getInstance(){
        if(instance==null){
            instance=new AppCore();
        }
        return instance;
    }

    public void run(){
        this.gui.start();
    }

    public static void main(String[] args) {
        ApplicationFramework appCore= AppCore.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        ErrorLogger consoleLogger = new ConsoleLogger();
        ErrorLogger fileLogger = new FileLogger();
        Serializer serializer = new GsonSerializer();
        appCore.initialise(gui, mapRepository,consoleLogger,fileLogger,serializer);
        ((FileLogger) fileLogger).obrisi();
        appCore.run();
    }
}

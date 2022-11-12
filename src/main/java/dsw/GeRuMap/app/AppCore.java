package dsw.GeRuMap.app;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.core.MapRepository;
import dsw.GeRuMap.app.gui.SwingGui;
import dsw.GeRuMap.app.gui.errorlogger.ConsoleLogger;
import dsw.GeRuMap.app.gui.errorlogger.ErrorLogger;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import dsw.GeRuMap.app.mapRepository.factory.ElementFactory;
import dsw.GeRuMap.app.mapRepository.factory.MindMapFactory;
import dsw.GeRuMap.app.mapRepository.factory.NodeFactory;

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
        ErrorLogger errorLogger = new ConsoleLogger();
        appCore.initialise(gui, mapRepository,errorLogger);
        appCore.run();
    }
}

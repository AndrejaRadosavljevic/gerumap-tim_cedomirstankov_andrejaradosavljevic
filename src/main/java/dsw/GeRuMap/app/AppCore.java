package dsw.GeRuMap.app;

import dsw.GeRuMap.app.core.ApplicationFramework;
import dsw.GeRuMap.app.core.Gui;
import dsw.GeRuMap.app.core.MapRepository;
import dsw.GeRuMap.app.gui.SwingGui;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;

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
        Gui gui = new SwingGui();
        ApplicationFramework appCore= AppCore.getInstance();
        MapRepository mapRepository = new MapRepositoryImpl();
        appCore.initialise(gui, mapRepository);
        appCore.run();
    }
}

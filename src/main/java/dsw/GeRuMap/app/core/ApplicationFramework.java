package dsw.GeRuMap.app.core;

import dsw.GeRuMap.app.gui.errorlogger.ErrorLogger;
import dsw.GeRuMap.app.gui.errorlogger.FileLogger;
import dsw.GeRuMap.app.gui.messagegenerator.MessageGeneratorImplementation;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;

@Getter
@Setter
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;

    public void run(){
        this.gui.start();
    };

    public void initialise(Gui gui, MapRepository mapRepository,ErrorLogger errorLogger){
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.errorLogger=errorLogger;
        MessageGeneratorImplementation.getInstance().addSubscriber(this.errorLogger);
        MessageGeneratorImplementation.getInstance().addSubscriber(FileLogger.getInstance());
    }
    //Singleton
    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public MapRepository getMapRepository(){
        if(mapRepository == null)mapRepository = new MapRepositoryImpl();
        return mapRepository;
    }
}

package dsw.GeRuMap.app.core;

import dsw.GeRuMap.app.gui.errorlogger.ErrorLogger;
import dsw.GeRuMap.app.gui.messagegenerator.MessageGeneratorImplementation;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger errorLogger;
    protected ErrorLogger fileLogger;

    public void run(){
        this.gui.start();
    };

    public void initialise(Gui gui, MapRepository mapRepository,ErrorLogger errorLogger, ErrorLogger fileLogger){
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.errorLogger=errorLogger;
        this.fileLogger=fileLogger;
        MessageGeneratorImplementation.getInstance().addSubscriber(this.errorLogger);
        MessageGeneratorImplementation.getInstance().addSubscriber(this.fileLogger);
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

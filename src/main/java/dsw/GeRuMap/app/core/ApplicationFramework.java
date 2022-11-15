package dsw.GeRuMap.app.core;

import dsw.GeRuMap.app.gui.errorlogger.ErrorLogger;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected MapRepository mapRepository;
    protected ErrorLogger consoleLogger;
    protected  ErrorLogger fileLogger;

    public void run(){
        this.gui.start();
    };

    public void initialise(Gui gui, MapRepository mapRepository, ErrorLogger consoleLogger, ErrorLogger fileLogger){
        this.gui = gui;
        this.mapRepository = mapRepository;
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;

        MainFrame.getInstance().getMessageGenerator().addSubscriber(this.consoleLogger);
        MainFrame.getInstance().getMessageGenerator().addSubscriber(this.fileLogger);
        MainFrame.getInstance().getMessageGenerator().addSubscriber(this.gui);
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

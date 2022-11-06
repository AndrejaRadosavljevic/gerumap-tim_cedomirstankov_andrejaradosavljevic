package dsw.GeRuMap.app.core;


import dsw.GeRuMap.app.mapRepository.MapRepositoryImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected MapRepository mapRepository;

    public void run(){
        this.gui.start();
    };

    public void initialise(Gui gui, MapRepository mapRepository){
        this.gui = gui;
        this.mapRepository = mapRepository;
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

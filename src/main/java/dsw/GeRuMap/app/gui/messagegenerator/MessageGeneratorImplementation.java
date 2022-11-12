package dsw.GeRuMap.app.gui.messagegenerator;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImplementation implements MessageGenerator{

    private List<ISubscriber> subscribers;

    private static MessageGeneratorImplementation instance;

    @Override
    public void generate(Type type) {
        if(type == Type.BRISANJE_PROJECT_EXPLORERA_ERROR)
            notifySubscriber(new Message("Ne mozete da obrisete project explorer",Type.BRISANJE_PROJECT_EXPLORERA_ERROR));
        if(type == Type.DODAVANJE_DETETA_ELEMENTU_ERROR)
            notifySubscriber(new Message("Ne mozete da dodate dete elementu",Type.DODAVANJE_DETETA_ELEMENTU_ERROR));
        if(type == Type.PRAZNO_IME_PROJEKTA_ERROR)
            notifySubscriber(new Message("Ne mozete da ostavite prazno ime projekta",Type.PRAZNO_IME_PROJEKTA_ERROR));
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(subscribers == null)subscribers = new ArrayList<>();
        if(!(subscribers.contains(sub)))subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if (subscribers==null)return;
        if(subscribers.isEmpty())return;
        for(ISubscriber sub:subscribers){
            sub.update(notification);
        }
    }

    public static MessageGeneratorImplementation getInstance() {
        if(instance == null)instance = new MessageGeneratorImplementation();
        return instance;
    }
}

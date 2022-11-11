package dsw.GeRuMap.app.gui.controller.observer;

public interface IPublisher {

    public void addSubscriber(ISubscriber sub);

    public void removeSubscriber(ISubscriber sub);

    public void notifySubscriber(Object notification);


}

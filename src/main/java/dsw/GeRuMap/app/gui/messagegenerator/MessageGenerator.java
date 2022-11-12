package dsw.GeRuMap.app.gui.messagegenerator;

import dsw.GeRuMap.app.gui.controller.observer.IPublisher;

public interface MessageGenerator extends IPublisher {
    void generate(Type type);
}

package dsw.GeRuMap.app.gui.errorlogger;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;

public interface ErrorLogger extends ISubscriber {
    void log();
}

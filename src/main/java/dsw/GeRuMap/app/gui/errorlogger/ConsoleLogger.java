package dsw.GeRuMap.app.gui.errorlogger;

import dsw.GeRuMap.app.gui.messagegenerator.Message;

public class ConsoleLogger implements ErrorLogger{

    @Override
    public void log() {

    }

    @Override
    public void update(Object notification) {
        System.out.println("Error - " + ((Message)notification).getContent());
    }
}

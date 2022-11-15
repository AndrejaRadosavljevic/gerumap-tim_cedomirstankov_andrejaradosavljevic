package dsw.GeRuMap.app.gui.errorlogger;

import dsw.GeRuMap.app.gui.messagegenerator.Message;


public class ConsoleLogger implements ErrorLogger{

    @Override
    public void log(Object notification) {
        System.out.println(((Message)notification).getContent());
    }

    @Override
    public void update(Object notification) {
        this.log( notification);
    }
}

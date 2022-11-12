package dsw.GeRuMap.app.gui.messagegenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    String content;
    Type type;

    public Message(String content, Type type){
        this.content=content;
        this.type=type;
    }
}

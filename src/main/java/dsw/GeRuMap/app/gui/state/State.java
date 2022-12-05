package dsw.GeRuMap.app.gui.state;

import java.awt.*;

public interface State {
    public void doState(Point x);

    void doState(Point x, Point y);
}

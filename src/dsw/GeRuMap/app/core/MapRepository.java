package dsw.GeRuMap.app.core;

import dsw.GeRuMap.app.main.MindMap;

import java.awt.*;
import java.awt.image.ColorModel;
import java.util.List;

public class MapRepository implements Composite {

    private List<MindMap> templateList;

    @Override
    public CompositeContext createContext(ColorModel srcColorModel, ColorModel dstColorModel, RenderingHints hints) {
        return null;
    }
}

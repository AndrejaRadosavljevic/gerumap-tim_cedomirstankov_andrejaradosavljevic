package dsw.GeRuMap.app.mapRepository.implementation;

import dsw.GeRuMap.app.gui.controller.observer.ISubscriber;
import dsw.GeRuMap.app.gui.view.MainFrame;
import dsw.GeRuMap.app.gui.view.MapTab;
import dsw.GeRuMap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.css.RGBColor;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

@Getter
@Setter
public class Element extends MapNode implements ISubscriber {
    private float debljina;
    private int boja;
    @ToString.Exclude
    private transient double scale;

    private  int pbr ;
    @ToString.Exclude
    private static int br = 0;



    public Element(String name, MapNode parent,float debljina, Color paint){
        super(name,parent);
        this.debljina = debljina;
        this.boja = paint.getRGB();
        scale = ((MapTab) MainFrame.getInstance().getTabPanel().getTabbedPane().getSelectedComponent()).getScale();
        pbr = br;
        br++;
    }

    public Element(String name, MapNode parent, int debljina, Color paint, double scale){
        super(name,parent);
        this.debljina = debljina;
        this.boja = paint.getRGB();
        this.scale=scale;
        pbr=br;
        br++;
    }

    public Element(String name, MapNode parent) {
        super(name, parent);
        debljina = 3;
        boja = Color.BLACK.getRGB();
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(pbr == ((Element)obj).pbr)return true;
            else return false;
        }
        return false;
    }

    @Override
    public void update(Object notification) {
        scale =( (MapTab)notification).getScale();
    }

    public void setStroke(Stroke stroke) {
        debljina = ((BasicStroke)stroke).getLineWidth();
    }

    public void setPaint(Paint paint) {
        boja = ((Color)paint).getRGB();
    }

    public void setPbr(){
        pbr = br++;
    }
}

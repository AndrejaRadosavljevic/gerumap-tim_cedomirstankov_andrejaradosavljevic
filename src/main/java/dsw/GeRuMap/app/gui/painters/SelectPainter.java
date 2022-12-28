package dsw.GeRuMap.app.gui.painters;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public class SelectPainter {

    private Point x;
    private Point y;

    public SelectPainter(Point x, Point y){
        this.x=x;
        this.y=y;
    }
    public void paint(Graphics2D g, double scale, double tx, double ty){
        Stroke dashedStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{10}, 0);
        g.setPaint(Color.BLACK);
        g.setStroke(dashedStroke);
        Point x1=new Point((int) ((x.x)/scale-tx), (int) ((x.y)/scale-ty));
        Point y1=new Point((int) ((y.x)/scale-tx), (int) ((y.y)/scale-ty));
        Rectangle rectangle=new Rectangle();
        rectangle.setFrameFromDiagonal(x1,y1);
        g.draw(rectangle);
    }
}

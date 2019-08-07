package compute_similarities;

import java.awt.*;

public class Spring {
    public static final double MAX_LENGTH = 200.0;

    private PDF[] hooks;
    private final double restingLength;

    private double tension;

    public Spring(PDF hook1, PDF hook2, double simularity){
        hooks = new PDF[2];
        hooks[0] = hook1;
        hooks[1] = hook2;
        double difference = (1-simularity);
        restingLength = difference * MAX_LENGTH;
        System.out.println("resting distance between " + hooks[0].name + " and " + hooks[1].name + " = " + restingLength);
    }

    public Spring(){
        super();
        hooks[0] = null;
        hooks[1] = null;
        restingLength = 0;
    }

    public void stepTension(){
        Point direction1To2 = normalize(new Point(hooks[0].getPosition().x-hooks[1].getPosition().x,hooks[0].getPosition().y-hooks[1].getPosition().y));

        double currentLength = hooks[0].getPosition().distance(hooks[1].getPosition());
        tension = (restingLength - currentLength) * 0.2;

        hooks[0].getPosition().translate(
                (int)(( direction1To2.x )*tension),
                (int)(( direction1To2.y )*tension));

        //System.out.println(tension);

        stepGravity();

    }

    public void stepGravity(){
        for (int i = 0; i < 2; i++) {

        Point directionToCenter = normalize(new Point(hooks[i].getPosition().x + 200,hooks[i].getPosition().y + 200));

        double currentLength = hooks[i].getPosition().distance(new Point(0,0));
        tension = (restingLength - currentLength) * 0.2;

        hooks[0].getPosition().translate(
                (int)(( directionToCenter.x )*tension),
                (int)(( directionToCenter.y )*tension));
        }
    }

    public void paint(Graphics g) {
        g.setColor(new Color(0,(int)clamp(122.0-((tension/MAX_LENGTH)*255.0),1,254),0));
        g.drawLine(
                hooks[0].getPosition().x + (PDF.ICON_WIDTH/2),hooks[0].getPosition().y + (PDF.ICON_HEIGHT/2),
                hooks[1].getPosition().x+ (PDF.ICON_WIDTH/2),hooks[1].getPosition().y + (PDF.ICON_HEIGHT/2));
    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    public Point normalize(Point v){
        if(v.x == 0 && v.y == 0){
            //System.err.println("Attempt to normalize vector with magnitude of 0");
            v.x = (int) ((Math.random()*100.0)-50.0);
            v.y = (int) ((Math.random()*100.0)-50.0);
        }
        double mag = Math.sqrt((v.x*v.x)+(v.y*v.y));


        v.x = (int) Math.round((double)v.x/mag);
        v.y = (int) Math.round((double)v.y/mag);
        return v;
    }
}

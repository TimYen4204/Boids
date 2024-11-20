package Object;

import Vector.Vector;

import java.awt.*;

public class Object extends Vector {

    public final int OFFSET = 300;
    public Vector acceleration;
    public Vector velocity;
    public Vector position;
    public double mass;
    public Color color = Color.white;

    public Object(double x, double y) {
        super(x, y);
    }


    protected void setFrame(double v, double v1, double x, double y) {
    }
}

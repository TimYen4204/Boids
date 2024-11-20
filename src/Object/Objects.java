package Object;

import Vector.Vector;

import java.awt.*;

public class Objects extends Vector {

    public final int OFFSET = 300;
    public Vector acceleration;
    public Vector velocity;
    public Vector position;
    public double mass;
    public Color color = Color.white;

    public Objects(double x, double y) {
        super(x, y);
    }



}

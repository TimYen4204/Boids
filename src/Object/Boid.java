package Object;
import Vector.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Boid extends Objects {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    public Ellipse2D.Double shape;

    public Boid(double x, double y, Vector position, Vector velocity, Vector acceleration) {
        super(x, y);
        this.position = new Vector((double) WIDTH /2, (double) HEIGHT /2);
        this.velocity = new Vector(Math.random(), Math.random());
        this.acceleration = new Vector(1, 1);
    }

    public Boid(int x, int y) {
        super(x, y);
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void update(){
        this.position.add(this.velocity);
        this.velocity.add(this.acceleration);
    }

    public void updateShape() {

        this.shape.setFrame(this.position.x + OFFSET, this.position.y + OFFSET, x, y);

    }

    public void checkWindowCollision(){
        // Floor
        if(this.shape.y >= HEIGHT){
            this.shape.y = 0;
        }else if (this.shape.y <= 0){
            this.shape.y = HEIGHT;
        }
        // Right boundary
        if(this.shape.x >= 800){
            this.shape.x = 0;
        }else if(this.shape.x <= 0){
            this.shape.x = WIDTH;
        }

    }

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

}

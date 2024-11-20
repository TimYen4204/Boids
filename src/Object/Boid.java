package Object;
import Vector.Vector;

import java.util.List;
import java.awt.geom.Ellipse2D;

public class Boid extends Object {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    public Ellipse2D.Double boid; // Represent the boid shape
    public Vector lastPosition = new Vector();

    public Boid(double x, double y) {
        super(x, y);
        this.boid = new Ellipse2D.Double(x, y, 5, 5);
        this.position = new Vector(Math.random() * WIDTH, Math.random() * HEIGHT);
        this.velocity = new Vector(Math.random() * 4 - 2, Math.random() * 4 - 2);
        this.acceleration = new Vector(Math.random(), Math.random());
    }
    public void update() {
        this.velocity.add(this.acceleration);
        x += velocity.x;
        y += velocity.y;
    }
    public void updateShape() {

        this.boid.setFrame(this.position.x + OFFSET, this.position.y + OFFSET, WIDTH, HEIGHT);

    }
    public void checkWindowCollision() {
        if(x >= WIDTH){
            x = 0;
        }
        if(x <= 0){
            x = WIDTH;
        }
        if(y >= HEIGHT){
            y = 0;
        }
        if(y <= 0){
            y = HEIGHT;
        }

        //if (x <= 0 || x >= 600) velocity.x = -velocity.x; // Bounce horizontally
        //if (y <= 0 || y >= 600) velocity.y = -velocity.y; // Bounce vertically
    }
    public Vector alignment(List<Boid> birds){

        Vector steer = this.velocity;
        double perceptionRadius = 10;
        int total = 0;

        for (Boid other : birds) {
            double d = this.distance(other);
            if(other != this && d < perceptionRadius) {
                steer = steer.add(other.velocity);
                total++;
            }
            if(total > 0){
                steer.scale((double) 1 /total);
                steer.subtract(this.velocity);
                return steer;
            }
        }
        return steer;
    }

    public void flock(List<Boid> birds){
    Vector align = alignment(birds);
    acceleration.add(align);
    }

    public void separation(){

    }
    public void cohesion(){

    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setVelocity(Vector velocity){
        this.velocity = velocity;
    }
}

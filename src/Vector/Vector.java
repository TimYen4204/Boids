package Vector;

public class Vector {
    public double x;
    public double y;

    public Vector () {
        this.x = 0;
        this.y = 0;
    }

    public Vector (double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other){
        return new Vector(x + other.x, y + other.y);
    }
    public Vector subtract(Vector other){
        return new Vector(x - other.x, y - other.y);
    }
    public Vector scale(double n){
        return new Vector (x * n, y * n);
    }
    public double distance(Vector other) {
        return Math.sqrt((other.x - x)*(other.x - x) + (other.y - y)*(other.y - y));
    }

}


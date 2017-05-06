package net.gamepickle;

/**
 * Created by Joseph on 29/04/2017.
 */
public class Node {
    public double x;
    public double y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double dot(Node node){
        // Dot Product between this vector and the passed one
        return x*node.x + y*node.y;
    }

    public Node normal() {
        // The normal of this vector
        return new Node(-1*y, x);
    }

    public Node normalize() {
        // The unit vector of this one
        double d = Math.sqrt(x*x+y*y);
        if(d == 0) {
            d = 1;
        }
        return new Node(x/d,y/d);
    }

}

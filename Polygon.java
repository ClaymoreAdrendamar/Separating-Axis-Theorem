package net.gamepickle;

import java.awt.*;

/**
 * Created by Joseph on 01/05/2017.
 */
public class Polygon extends Shape{
    private Node[] nodes;

    public Polygon(double[] x, double[] y) {
        nodes = new Node[x.length];
        //System.out.println("New Shape");
        for(int i=0; i<x.length; i++) {
            nodes[i] = new Node(x[i], y[i]);
            //System.out.println("Point: "+nodes[i].x+", "+nodes[i].y);
        }
    }

    public Node[] getAxes() {
        Node[] axes = new Node[nodes.length];
        Node vector = new Node(0,0);
        for(int i = 0; i < nodes.length; i++) {
            vector.x = nodes[i].x - nodes[i+1==nodes.length ? 0:i+1].x;
            vector.y = nodes[i].y - nodes[i+1==nodes.length ? 0:i+1].y;
            axes[i] = vector.normal().normalize();
        }
        return axes;
    }

    public Node getNode(int i, Node axis) {
        return nodes[i];
    }

    public int getNumOfNodes() {
        return nodes.length;
    }
}

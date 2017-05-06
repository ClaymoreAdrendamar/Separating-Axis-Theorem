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
        // Return the normal of every edge of the polygon
        Node[] axes = new Node[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            // Get the vector of the edge
            Node vector = new Node(nodes[i].x - nodes[i+1==nodes.length ? 0:i+1].x,
                    nodes[i].y - nodes[i+1==nodes.length ? 0:i+1].y);
            // Get the normal of the unit vector of the edge
            axes[i] = vector.normal().normalize();
        }
        return axes;
    }

    public Node getNode(int i, Node axis) {
        // Get node at index i
        return nodes[i];
    }

    public int getNumOfNodes() {
        // Get the number of nodes in the Polygon
        return nodes.length;
    }
}

package net.gamepickle;

/**
 * Created by Joseph on 02/05/2017.
 */
public class Circle extends Shape{
    private Node center;
    private double radius;

    public Circle(Node center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Node getNode(int i, Node Axis) {
        // Get the 2 nodes according to the axis the shape is being projected along
        if(i==0) {
            return new Node(center.x + (-Axis.normal().y * radius),  center.y + (Axis.normal().x * radius));
        } else {
            return new Node(center.x + (Axis.normal().y * radius),  center.y + (-Axis.normal().x * radius));
        }
    }

    public Node[] getAxes() {
        // A circle has no normals
        return new Node[]{};
    }

    public int getNumOfNodes() {
        // The circle has two nodes
        return 2;
    }
}

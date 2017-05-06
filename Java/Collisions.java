package net.gamepickle;

import java.lang.reflect.Array;

/**
 * Created by Joseph on 27/04/2017.
 */
public class Collisions {

    private Collisions() {
        // You cannot create an instance of collisions
    }

    public static void main(String[] args) {
        // Test a collision detection between a Triangle and a Circle
        System.out.println(testCollision(new Polygon(new double[]{1,3,1}, new double[]{1,2,3}),
                new Circle(new Node(-1,-1),3)));
    }

    private static boolean testCollision(Shape A, Shape B){
        // Test collisions between two Shapes: they can be any child of Shape (Circle or Polygon)
        Node[] axes = concatenate(A.getAxes(), B.getAxes()); // Get the array of all the axes to project the shapes along

        for (Node axis: axes) { // Loop over the axes
            // project both Shapes onto the axis
            Projection pA = project(A, axis);
            Projection pB = project(B, axis);
            // do the projections overlap?
            if (!pA.overlap(pB)) {
                // If they don't, the shapes don't either so return false
                return false;
            }
        }

        // All the projections overlap: the shapes collide -> return True
        return true;
    }

    private static Projection project(Shape a, Node axis) {
        // Project the shapes along the axis
        double min = axis.dot(a.getNode(0, axis)); // Get the first min
        double max = min;
        for (int i = 1; i < a.getNumOfNodes(); i++) {
            double p = axis.dot(a.getNode(i, axis)); // Get the dot product between the axis and the node
            if (p < min) {
                min = p;
            } else if (p > max) {
                max = p;
            }
        }
        return new Projection(min, max);
    }

    public static Node[] concatenate (Node[] a, Node[] b) {
        // Concatenate the two arrays of nodes
        int aLen = a.length;
        int bLen = b.length;

        Node[] c = (Node[]) Array.newInstance(a.getClass().getComponentType(), aLen+bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

}

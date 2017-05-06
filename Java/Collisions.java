package net.gamepickle;


/**
 * Created by Joseph on 27/04/2017.
 */
public class Collisions {

    private Collisions() {
    }

    public static void main(String[] args) {
        System.out.println(test_collision(new Polygon(new double[]{1,3,1}, new double[]{1,2,3}),
                new Circle(new Node(-1,-1),3)));
    }

    private static boolean test_collision(Shape A, Shape B){
        Node[] axesA = A.getAxes();
        Node[] axesB = B.getAxes();

        for (int i = 0; i < axesA.length; i++) {
            Node axis = axesA[i];
            // project both Polygons onto the axis
            Projection p1 = project(A, axis);
            Projection p2 = project(B, axis);
            // do the projections overlap?
            if (!p1.overlap(p2)) {
                // then we can guarantee that the Polygons do not overlap
                return false;
            }
        }

        for (int i = 0; i < axesB.length; i++) {
            Node axis = axesB[i];
            // project both Polygons onto the axis
            Projection p1 = project(A, axis);
            Projection p2 = project(B, axis);
            // do the projections overlap?
            if (!p1.overlap(p2)) {
                // then we can guarantee that the Polygons do not overlap
                return false;
            }
        }
        return true;
    }

    private static Projection project(Shape a, Node axis) {
        //System.out.println("Axis X: "+axis.x+" Y: "+axis.y);
            double min = axis.dot(a.getNode(0, axis));
            double max = min;
            for(int i=1; i<a.getNumOfNodes(); i++) {
                double p = axis.dot(a.getNode(i, axis));
                if(p < min) {
                    min = p;
                } else if(p > max) {
                    max = p;
                }
            }
            return new Projection(min, max);
    }

}

package net.gamepickle;

/**
 * Created by Joseph on 29/04/2017.
 */
public abstract class Shape {
    // Base shape, any shape that wants to be able to be used in SAT must extend Shape
    public abstract Node getNode(int i, Node Axis);
    public abstract Node[] getAxes();
    public abstract int getNumOfNodes();


}

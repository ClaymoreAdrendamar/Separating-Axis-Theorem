package net.gamepickle;

/**
 * Created by Joseph on 01/05/2017.
 */
public class Projection {
    private double min;
    private double max;

    public Projection(double min, double max) {
        // Create the projection with it's two values: min, max
        this.min = min;
        this.max = max;
    }

    public boolean overlap(Projection p2) {
        // Check if this projection overlaps with the passed one
        return (!(p2.max < this.min || this.max < p2.min));
    }
}

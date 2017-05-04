package net.gamepickle;

/**
 * Created by Joseph on 01/05/2017.
 */
public class Projection {
    private double min;
    private double max;

    public Projection(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public boolean overlap(Projection p2) {
        return (!(p2.max < this.min || this.max < p2.min));
    }
}

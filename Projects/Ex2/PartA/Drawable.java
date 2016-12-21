package PartA;

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public interface Drawable {
    public boolean equals(Drawable d);
    public boolean contains(Point p);
    public double perimeter();
    public double area();
    public void translate(Point p);
}

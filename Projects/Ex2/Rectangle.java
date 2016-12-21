/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Rectangle implements Drawable{
    @Override
    public boolean equals(Drawable d) {
        return false;
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void translate(Point p) {

    }
}

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Point implements Drawable{
    double _x;
    double _y;

    public Point(double _x, double _y){
        this._x = _x;
        this._y = _y;
    }

    @Override
    public boolean equals(Drawable d) {
        return false;
    }

    @Override
    public boolean contains(Point p) {
        return ((p._x == _x) && (p._y == _y));
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

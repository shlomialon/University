package PartA;

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

    public Point(Point p){
        this._x = p._x;
        this._y = p._y;
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
        if(p != null){
            this._x = this._x + p._x;
            this._y = this._y + p._y;
        }else{
            System.err.println("PartA.Point can't be a null ");
        }
    }

    public double distance(Point p) {
        if (p == null) {
            return 0;
        }
        double dx = p._x - this._x, dy = p._y - this._y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return "name: " + this.getClass() + "[" + _x + "," + _y + "]";
    }
}

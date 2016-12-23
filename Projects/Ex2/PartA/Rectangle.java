package PartA;

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Rectangle implements Drawable{
    Point p1;
    Point p2;

    public Rectangle(Point p1,Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Rectangle(Rectangle r){
        this.p1 = r.p1;
        this.p2 = r.p2;
    }
    @Override
    public boolean equals(Drawable d) {
        return false;
    }

    @Override
    public boolean contains(Point p) {
        boolean flag = false;
        if (p != null) {
            if (p._x >= p1._x && p._x <= p2._x && p._y >= p1._y && p._y <= p2._y) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public double perimeter() {
        return 2*(Math.abs(p2._x - p1._x) + Math.abs(p2._y - p1._y));
    }

    @Override
    public double area() {
        return (Math.abs(p2._x - p1._x) * Math.abs(p2._y - p1._y));
    }

    @Override
    public void translate(Point p) {
        if(p != null) {
            p1.translate(p);
            p2.translate(p);
        }
    }

    public double dx() {
        return Math.abs(p2.get_x() - p1.get_x());
    }

    public double dy() {
        return Math.abs(p2.get_y() - p1.get_y());
    }

    public Point p1() {
        return p1;
    }

    public Point p2() {
        return p2;
    }

    public String toString() {
       // return "Name: " + this.getClass() + "[" + p1 + "," + p2 + "]";
        return "1";
    }
}

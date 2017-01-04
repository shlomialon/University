package PartA;


/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Triangle implements Drawable{

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
        this.p3 = new Point(p3);
    }

    public Triangle(Triangle t){
    	this(t.p1,t.p2,t.p3);
    }

    @Override
    public boolean equals(Drawable d) {
        return d instanceof Triangle && p1 == ((Triangle) d).p1 && p2 == ((Triangle) d).p2 && p3 == ((Triangle) d).p3;
    }

    @Override
    public boolean contains(Point p) {
        if (p != null) {
            Triangle t1 = new Triangle(p1, p2, p);
            Triangle t2 = new Triangle(p1, p, p3);
            Triangle t3 = new Triangle(p, p2, p3);
            double sumTs = t1.area() + t2.area() + t3.area();
            if (Math.abs(this.area()-sumTs)<=0.001) {
                return true;
            }
        }
        return false;
    }

    public double perimeter() {
        return  (p1.distance(p2) + p2.distance(p3) + p3.distance(p1));
    }

    public double area() {
       //double D = perimeter() / 2;
       //return Math.sqrt((D * (D - p1.distance(p2)) * (D - p2.distance(p3)) * (D - p1.distance(p3))));
        return Math.abs((p1.get_x()*(p2.get_y()-p3.get_y()) + p2.get_x()*(p3.get_y()-p1.get_y())+ p3.get_x()*(p1.get_y()-p2.get_y()))/2.0);

    }

    public void translate(Point p) {
        if (p != null) {
            p1.translate(p);
            p2.translate(p);
            p3.translate(p);
        }
    }

    Point p1() {
        return p1;
    }

    Point p2() {
        return p2;
    }

    Point p3() {
        return p3;
    }

    public String toString() {
        //return "Name: " + this.getClass() + "[" + p1 + "," + p2 + "," + p3 + "]";
        return "2";
    }
}

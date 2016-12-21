package PartA;

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Triangle implements Drawable{

    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(Triangle t){
        this.p1 = t.p1;
        this.p2 = t.p2;
        this.p3 = t.p3;
    }

    @Override
    public boolean equals(Drawable d) {
        return false;
    }

    @Override
    public boolean contains(Point p) {
        boolean flag = false;
        if (p != null) {
            Triangle t1 = new Triangle(p1, p2, p);
            Triangle t2 = new Triangle(p1, p, p3);
            Triangle t3 = new Triangle(p, p2, p3);
            double sumTs = t1.area() + t2.area() + t3.area();
            double sumT = area();
            if (sumT >= sumTs - 0.001 && sumT <= sumTs + 0.001) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public double perimeter() {
        return  (p1.distance(p2) + p2.distance(p3) + p3.distance(p1));
    }

    @Override
    public double area() {
        double D = perimeter() / 2;
        return Math.sqrt((D * (D - p1.distance(p2)) * (D - p2.distance(p3)) * (D - p1.distance(p3))));
    }

    @Override
    public void translate(Point p) {
        if (p != null) {
            p1.translate(p);
            p2.translate(p);
            p3.translate(p);
        }
    }

    public String toString() {
        //return "Name: " + this.getClass() + "[" + p1 + "," + p2 + "," + p3 + "]";
        return "2";
    }
}

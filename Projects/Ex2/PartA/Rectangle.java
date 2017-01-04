package PartA;

/**
 * Created by Shlomi Alon on 19/12/2016.
 */
public class Rectangle implements Drawable{
    private Point p1;
    private Point p2;

    public Rectangle(Point p1,Point p2){
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public Rectangle(Rectangle r){
    	this(r.p1,r.p2);
    }
    @Override
    public boolean equals(Drawable d) {
        return d instanceof Rectangle && ((Rectangle) d).p1 == p1 && ((Rectangle) d).p2 == p2;
    }

    @Override
    public boolean contains(Point p) {
       /* boolean flag = false;
        if (p != null) {
            if (p._x >= p1._x && p._x <= p2._x && p._y >= p1._y && p._y <= p2._y) {
                flag = true;
            }
        }
        return flag;*/
    	if(p!=null){
			boolean x1,y1;
			x1 =Math.min(this.p1.get_x(),this.p2.get_x())<p.get_x()&&p.get_x()<Math.max(this.p1.get_x(),this.p2.get_x());
			y1 = Math.min(this.p1.get_y(),this.p2.get_y())<p.get_y()&&p.get_y()<Math.max(this.p1.get_y(),this.p2.get_y());
			return p!=null&&x1&&y1;
			}
			return false;
        
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

    double dx() {
        return Math.abs(p2.get_x() - p1.get_x());
    }

    double dy() {
        return Math.abs(p2.get_y() - p1.get_y());
    }

    Point p1() {
        return p1;
    }

    Point p2() {
        return p2;
    }

    public String toString() {
       // return "Name: " + this.getClass() + "[" + p1 + "," + p2 + "]";
        return "1";
    }
}

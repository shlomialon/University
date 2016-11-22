
public class Point3 {

	private double x;
	private double y;
	private double z;
	
	public Point3(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3(Point3 p){
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}

	public double distance(Point3 p){
	double ans = Math.pow((this.x + p.x),2) + Math.pow((this.y + p.y),2) + Math.pow((this.z + p.z),2);
		return Math.abs(ans);
	}
	
	public boolean equals(Point3 p){
		if((this.x == p.x) && (this.y == p.y) && (this.z == p.z))
		return true;
			return false;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}	
}

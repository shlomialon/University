
public class Balloon {

	private Point3 c;
	private double r;

	public Balloon(Point3 p,double r){
		this.c = p;
		this.r = r;
	}

	public Balloon(Balloon b){
		this.c = b.c;
		this.r = b.r;
	}

	public Point3 getCenter(Point3 c){
		return c;
	}

	public double getRadius(double r){
		return r;
	}

	public Point3 getP() {
		return c;
	}

	public void setP(Point3 c) {
		this.c = c;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double distCenter(Balloon p){
		double ans = Math.pow((this.c.getX() + p.getP().getX()),2) + Math.pow((this.c.getY() + p.getP().getY()),2) + Math.pow((this.c.getZ() + p.getP().getZ()),2);
		return Math.abs(ans);
	}
	
	public boolean containPont(Point3 p1){
		if(p1.getX() <= (c.getX() + r) && p1.getX() >= (c.getX() - r) && 
				p1.getY() <= (c.getY() + r) && p1.getY() >= (c.getY() - r) &&
					p1.getZ() <= (c.getZ() + r) && p1.getZ() >= (c.getZ() - r))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Balloon [c=" + c + ", r=" + r + "]";
	}
}

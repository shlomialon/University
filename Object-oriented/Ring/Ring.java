public class Ring {

	private Point p;
	private double r;
	private double R;

	public Ring(Point p, double r, double R){
		this.p = p;
		this.r = r;
		this.R = R;
	}

	public Ring(Ring ring){
		this.p = ring.p;
		this.r = ring.r;
		this.R = ring.R;
	}

	public double dis(Point p2){
		double dis = 0;
		dis = Math.pow(this.p.x() - p2.x(), 2) + Math.pow(this.p.y() - p2.y(), 2);
		return Math.sqrt(dis);
	}

	public boolean isIn(Point p1) {
		if(this.p.distance(p1) <= this.R){
			return true;}
		return false;
	}
	
	public boolean equals(Ring other){
		if(this.p.x() == other.p.x() && this.p.y() == other.p.y() && this.r == other.r  && this.R == other.R)
			return true;
		else
			return false;
	}
	
public String ToString(){
		return ", " + this.R + ", " + this.r + ", " + this.p ;
	}

	public static void main(String[] args) {
		//Point p = new Point (6,9);
		Point p1 = new Point (2,4);
		Ring ring = new Ring(p1, 2 ,6);
		Point p2 = new Point (2,4);
		Ring ring1 = new Ring(p2, 2 ,6);
		System.out.println(ring1.equals(ring));
		
		
	}
}

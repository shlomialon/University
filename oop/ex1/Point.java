public class Point {

	 int x;
	 int y;
	
	public Point(int _x, int _y){
		this.x = _x;
		this.y = _y;
	}
	
	public Point(Point p){
		this.x = p.x;
		this.y = p.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

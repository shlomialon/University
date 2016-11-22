<<<<<<< HEAD
import java.awt.Point;

public class Ball {

	private static Point p;
	
	public Ball(Point p){
		this.p = p;
	}

	public void moveLeft(double x){
		p.x += x;
	}
	
	public void moveRight(double x){
		p.x -= x;
	}
	
	public void moveForward(double y){
		p.y += y;
	}
	
	public void moveBack(double y){
		p.x -= y;
	}
	
	public static Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Ball [p=" + p + "]";
	}	
}
=======
import java.awt.Point;

public class Ball {

	private static Point p;
	
	public Ball(Point p){
		this.p = p;
	}

	public void moveLeft(double x){
		p.x += x;
	}
	
	public void moveRight(double x){
		p.x -= x;
	}
	
	public void moveForward(double y){
		p.y += y;
	}
	
	public void moveBack(double y){
		p.x -= y;
	}
	
	public static Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Ball [p=" + p + "]";
	}	
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374

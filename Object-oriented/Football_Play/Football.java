<<<<<<< HEAD
import java.awt.Point;

public class Football extends Ball{

	final private double w;
	final private double h;
	
	public Football(Point p,double w,double h){
		super(p);
		this.h = h;
		this.w = w;
	}

	public Football(Football f){
	 super(getP());
	 h = f.h;
	 w = f.w;
	}
	
	public void moveLeft(int dist) {
		getP().x -= dist;
		if(getP().x < 0) getP().x = 0;
	}
	
	public void moveRight(int dist) {
		getP().x += dist;
		if(getP().x >= w) getP().x = (int)(w - 1.0);
	}
	
	public void moveForward(int dist) {
		getP().y += dist;
		if(getP().y >= h) getP().y = (int)(h - 1.0);
	}
	
	public void moveBack(int dist) {
		getP().y -= dist;
		if(getP().y < 0) getP().y = 0;
	}
	
	@Override
	public String toString() {
		return "Football [w=" + w + ", h=" + h + "]";
	}
}
=======
import java.awt.Point;

public class Football extends Ball{

	final private double w;
	final private double h;
	
	public Football(Point p,double w,double h){
		super(p);
		this.h = h;
		this.w = w;
	}

	public Football(Football f){
	 super(getP());
	 h = f.h;
	 w = f.w;
	}
	
	public void moveLeft(int dist) {
		getP().x -= dist;
		if(getP().x < 0) getP().x = 0;
	}
	
	public void moveRight(int dist) {
		getP().x += dist;
		if(getP().x >= w) getP().x = (int)(w - 1.0);
	}
	
	public void moveForward(int dist) {
		getP().y += dist;
		if(getP().y >= h) getP().y = (int)(h - 1.0);
	}
	
	public void moveBack(int dist) {
		getP().y -= dist;
		if(getP().y < 0) getP().y = 0;
	}
	
	@Override
	public String toString() {
		return "Football [w=" + w + ", h=" + h + "]";
	}
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374

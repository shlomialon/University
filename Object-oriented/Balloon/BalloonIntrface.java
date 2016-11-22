import java.awt.Point;

public interface BalloonIntrface {

	public Point getCenter();// returns the center of the balloon
	public double getRadius();//returns the radius of the balloon
	public double distCenter(Balloon p);// returns the distance from point p to the
	 // center of the balloon
	public boolean containPont(Point p);//
	}

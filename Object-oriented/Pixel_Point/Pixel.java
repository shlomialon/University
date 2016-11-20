import java.awt.Color;
import java.util.ArrayList;

public class Pixel extends Point {

	private Color color;
	
	public Pixel(int _x, int _y, Color color){
		super(_x, _y);
		this.color = color;
	}
	
	public Pixel(Pixel p){
		super(p.getX(), p.getY());
		this.color = p.color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public static ArrayList<Pixel> samcolor(ArrayList<Pixel> lp, Color color){
		for(int i=0; i < lp.size(); i++){
			Pixel p = lp.get(i);
			if(!p.getColor().equals(color))
				lp.remove(i);
		}
		return lp;
	}
	
}

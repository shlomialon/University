package A_2016;

public class Point{
	private int x, y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){
		x = 0;
		y = 0;
	}
	public int x(){
		return x;
	}
	public int y(){
		return y;
	}
	public String toString(){
		return "("+x+","+y+")";
	}
	 public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         Point point = (Point) o;

         if (y != point.y) return false;
         return x == point.x;
     }

     @Override
     public int hashCode() {
         int result = y;
         result = 31 * result + x;
         return result;
     }
}

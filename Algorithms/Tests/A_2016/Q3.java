
public class Q3 {
	Node[][] nodes;
	Point p1, p2;
	int Cprice;
	int paths;
	// added my own two variables. was told I'm allowed to.
	public Q3(Node[][] nodes, Point p1, Point p2){
		
		int n= nodes.length;
		int m= nodes[0].length;
		
		this.p1 = new Point(p1.x(), p1.y());
		this.p2 = new Point(p2.x(), p2.y());
		
		// if start or end are in the dead zone.
		if(isDead(0, 0) || isDead(n-1, m-1)){
			Cprice = -1;
			paths = 0;
			return;
		}
		
		this.nodes = new Node[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				this.nodes[i][j] = new Node(nodes[i][j].x, nodes[i][j].y);
			}
		}
		
		// if price of node = -1, that means it is in dead zone, or no way to get to is.
		for (int i = 1; i < n; i++) {
			if(isDead(i, 0) || this.nodes[i-1][0].price == -1){
				//if i'm in dead zone, or any before me in this line were in dead zone.
				// then no way to get to me.
				this.nodes[i][0].price = -1;
				this.nodes[i][0].numOfPaths = 0;
			}
			else{// not in the dead area. neither is past one.
				this.nodes[i][0].price = this.nodes[i-1][0].price + nodes[i-1][0].y;
				this.nodes[i][0].numOfPaths = 1;
			}
		}
		for (int j = 1; j < m; j++) {
			if(isDead(0, j) || this.nodes[0][j-1].price == -1){
				//if i'm in dead zone, or any before me in this line were in dead zone.
				// then no way to get to me.
				this.nodes[0][j].price = -1;
				this.nodes[0][j].numOfPaths = 0;
			}
			else{// not in the dead area. neither is past one.
				this.nodes[0][j].price = this.nodes[0][j-1].price + nodes[0][j-1].x;
				this.nodes[0][j].numOfPaths = 1;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int left = this.nodes[i][j-1].price;// price of node to left
				int down = this.nodes[i-1][j].price;// price of node under
				if(isDead(i, j) || (left == -1 && down == -1)){ // I'm in dead zone, or no way to get to me from either side.
					this.nodes[i][j].price = -1;
					this.nodes[i][j].numOfPaths = 0;
				}
				else{// at least one way to get to me.
					if(left == -1){
						this.nodes[i][j].price = this.nodes[i-1][j].price + nodes[i-1][j].y;
						this.nodes[i][j].numOfPaths = this.nodes[i-1][j].numOfPaths;
					}
					else if(down == -1){
						this.nodes[i][j].price = this.nodes[i][j-1].price + nodes[i][j-1].x;
						this.nodes[i][j].numOfPaths = this.nodes[i][j-1].numOfPaths;
					}
					else{// both ways are optional.
						int a= this.nodes[i-1][j].price + nodes[i-1][j].y;
						int b= this.nodes[i][j-1].price + nodes[i][j-1].x;
						this.nodes[i][j].price = Math.min(a, b);
						
						if(a<b){
							this.nodes[i][j].numOfPaths = this.nodes[i-1][j].numOfPaths;
						}
						else if(a>b){
							this.nodes[i][j].numOfPaths = this.nodes[i][j-1].numOfPaths;
						}
						else{
							this.nodes[i][j].numOfPaths = this.nodes[i-1][j].numOfPaths + this.nodes[i][j-1].numOfPaths;
						}
					}
				}
			}
		}
		
		Cprice = this.nodes[n-1][m-1].price;
		paths = this.nodes[n-1][m-1].numOfPaths;
		
	}
	
	private boolean isDead(int i, int j){
		// if it is out of dead zone from buttom of left, then it is not dead.
		if( j < p1.y() || i < p1.x())return false;
		
		// if it is out of dead zone from top or right, then it is not dead.
		if( j > p2.y() || i > p2.x())return false;
		return true;
	}
	
	// if no way to get to end will return -1 as price.
	public int cheapestPathPrice(){
		return Cprice;
	}
	// if no way to get to end will return 0 as amount of paths.
	public int numOfCheapestPaths(){
		return paths;
	}
	
	public static void main(String[] args) {
		//InitMatrixOfPrices init= new InitMatrixOfPrices();
		
		Node[][] nodes = InitMatrixOfPrices.initMatOfNodes2();
		Q3 plain= new Q3(nodes, new Point(1,1), new Point(2,3));
		int price = plain.cheapestPathPrice();
		int paths = plain.numOfCheapestPaths();
		if(price != 28 || paths != 1)System.out.println("ERROR 1");
		
		Q3 plain2= new Q3(nodes, new Point(1,0), new Point(2,2));
		price = plain2.cheapestPathPrice();
		paths = plain2.numOfCheapestPaths();
		if(price != 26 || paths != 1)System.out.println("ERROR 2");
		
		Q3 plain3= new Q3(nodes, new Point(1,0), new Point(2,3));
		price = plain3.cheapestPathPrice();
		paths = plain3.numOfCheapestPaths();
		if(price != -1 || paths != 0)System.out.println("ERROR 2");
		
		Q3 plain4= new Q3(nodes, new Point(0,0), new Point(2,2));
		price = plain4.cheapestPathPrice();
		paths = plain4.numOfCheapestPaths();
		if(price != -1 || paths != 0)System.out.println("ERROR 2");
		
		Q3 plain5= new Q3(nodes, new Point(1,0), new Point(3,3));
		price = plain5.cheapestPathPrice();
		paths = plain5.numOfCheapestPaths();
		if(price != -1 || paths != 0)System.out.println("ERROR 2");
	}

	
	
	
}
class Node{
	int x, y, price, numOfPaths;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.price = 0;
		this.numOfPaths = 0;
	}
	public String toString(){
		return "x="+x+" y="+y+" price="+price+" np="+numOfPaths+";";
	}
}// class Node

class Point {
	private int x, y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){
		x = 0;
		y = 0;
	}
	public int x(){ return x; }
	public int y(){ return y; }
	public String toString(){
		return "("+x+","+y+")";
	}
}

class InitMatrixOfPrices {

	//mat that was given as examle
	public static Node[][] initMatOfNodes2(){ // n = 4
		int n=4;
		Node mat[][] = new Node[n][n];
		// the 1-st row
		mat[0][0] = new Node(1,3);
		mat[0][1] = new Node(8,4);
		mat[0][2] = new Node(3,8);
		mat[0][3] = new Node(0,4);
		// the 2-nd row
		mat[1][0] = new Node(2,5);
		mat[1][1] = new Node(5,11);
		mat[1][2] = new Node(3,1);
		mat[1][3] = new Node(0,2);
		// the 3-d row
		mat[2][0] = new Node(4,10);
		mat[2][1] = new Node(3,1);
		mat[2][2] = new Node(1,4);
		mat[2][3] = new Node(0,8);
		// the 4-th row
		mat[3][0] = new Node(2,0);
		mat[3][1] = new Node(3,0);
		mat[3][2] = new Node(5,0);
		mat[3][3] = new Node(0,0);
		return mat;
	}
}


package A_2016;

import java.util.ArrayList;
public class Q3 {
	
	private ArrayList<Point> deadArea;
	private Node[][] mat;
	int cheapestPrice;
	int numOfPaths;

	public Q3(Node[][] mat, Point p1, Point p2){
		if (mat != null) {
			this.mat = mat;
		} 
		deadArea = new ArrayList<>();
		for (int i = p1.x(); i <= p2.x(); i++) {
			for (int j = p1.y(); j <= p2.y(); j++) {
				deadArea.add(new Point(i, j));
			}
		}
	
		buildMatrix();
	}      
	public void buildMatrix(){
		int n = mat.length, m = mat[0].length;
		for (int i = 1; i < n; i++) {
			if (deadArea.contains(new Point(i, 0))) {
				mat[i][0].isDead = true;
			}
			mat[i][0].entry = mat[i - 1][0].entry + mat[i - 1][0].y;  
			mat[i][0].numOfPaths = 1;
		}
		for (int j = 1; j < m; j++) {
			if (deadArea.contains(new Point(0, j))) {
				mat[0][j].isDead = true;
			}
			mat[0][j].entry = mat[0][j - 1].entry + mat[0][j - 1].x;
			mat[0][j].numOfPaths = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int y;
				int x;
				if (deadArea.contains(new Point(i - 1, j))) {
					y = Integer.MAX_VALUE;
				} else {
					y = mat[i - 1][j].entry + mat[i - 1][j].y;
				}
				if (deadArea.contains(new Point(i, j - 1))) {
					x = Integer.MAX_VALUE;
				} else {
					x = mat[i][j - 1].entry + mat[i][j - 1].x;
				}
				//mat[i][j].isDead = true;
				mat[i][j].entry = x <= y ? x : y;
				if (y < x) mat[i][j].numOfPaths = mat[i - 1][j].numOfPaths;
				else if (y > x) mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths;
				else mat[i][j].numOfPaths = mat[i][j - 1].numOfPaths + mat[i - 1][j].numOfPaths;
			}
		}
		numOfPaths = mat[n - 1][m - 1].numOfPaths;
		cheapestPrice = mat[n - 1][m - 1].entry;
	}

	public int cheapestPathPrice(){
		return cheapestPrice;
	}
	public int numOfCheapestPaths(){
		return numOfPaths;
	}

	public static Node[][] initMatOfNodes(){ // n = 4
		int n=4;
		Node mat[][] = new Node[n][n];
		//the 1-st row
		mat[0][0] = new Node(1,3);
		mat[0][1] = new Node(8,4);
		mat[0][2] = new Node(3,8);
		mat[0][3] = new Node(0,4);
		//the 2-nd row
		mat[1][0] = new Node(2,5);
		mat[1][1] = new Node(5,11);
		mat[1][2] = new Node(3,1);
		mat[1][3] = new Node(0,2);
		//the 3-d row
		mat[2][0] = new Node(4,10);
		mat[2][1] = new Node(3,1);
		mat[2][2] = new Node(1,4);
		mat[2][3] = new Node(0,8);
		//the 4-th row
		mat[3][0] = new Node(2,0);
		mat[3][1] = new Node(3,0);
		mat[3][2] = new Node(5,0);
		mat[3][3] = new Node(0,0);
		return mat;
	}

	
	public static void printMatrixEntery(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].entry + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printMatrixX(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].x + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printMatrixY(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].y + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printMatrixCheap(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].numOfPaths + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void printMatrixIsDead(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].isDead + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node mat[][] = initMatOfNodes();
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,3);
		Q3 test = new Q3(mat,p1,p2);
		//test.buildMatrix();
		printMatrixEntery(mat);
		printMatrixX(mat);
		printMatrixY(mat);
		printMatrixCheap(mat);
		printMatrixIsDead(mat);
		System.out.println(test.numOfCheapestPaths());
		System.out.println(test.cheapestPathPrice());
		
	}
}

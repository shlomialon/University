

import java.util.Vector;

public class Question3 {

	//--Object Variables
	private Node[][] matrix;
	static Vector<String> vector = new Vector<>();

	//--Constructor
	public Question3(Node[][] matrix) {
		this.matrix = new Node[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				this.matrix[i][j] = new Node(matrix[i][j].x, matrix[i][j].y);
				this.matrix[i][j].price = matrix[i][j].price;
			}
		}
	}

	//--Answer for first question
	public boolean belongs(Node n) {
		if ((n.x == 0) && (n.y == 0)) return true;
		for (String element : vector) {
			int x = 0, y = 0;
			for (int i = 0; i < element.length(); i++) {
				if (element.charAt(i) == '0') x++;
				else y++;
				if ((n.x == x) && (n.y == y)) return true;
			}
		}
		return false;
	}

	//--Answer for second question
	public boolean allNodesBelong(Node[] nodes) {
		for (String element : vector) {
			boolean isContain = false;
			int index = 0;
			for (Node node : nodes) {
				isContain = false;
				int x = 0, y = 0;
				for (int i = index; i < element.length(); i++) {
					if (element.charAt(i) == '0') x++;
					else y++;
					if ((node.x == x) && (node.y == y)) {
						isContain = true;					
						index = i;
						break;
					}
				}
				if ((node.x == 0) && (node.y == 0)) isContain = true;
				if (!isContain) break; 				
			}
			if (isContain) return true;
		}
		return false;
	}

	public void shortestPaths() {
		for (int i = 1; i < matrix.length; i++) { //--Rows
			matrix[i][0].price = matrix[i - 1][0].price + matrix[i - 1][0].y;
		}
		for (int i = 1; i < matrix[0].length; i++) { //--Columns
			matrix[0][i].price = matrix[0][i - 1].price + matrix[0][i - 1].x;
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				matrix[i][j].price = Math.min(matrix[i][j - 1].price + matrix[i][j - 1].x,
						matrix[i - 1][j].price + matrix[i - 1][j].y);
			}
		}
	}

	public void calculateAllShortestPaths() {
		calculateAllShortestPaths(this.matrix, "", matrix.length - 1, matrix[0].length - 1);
	}
	private void calculateAllShortestPaths(Node[][] matrix, String ans, int i, int j) {
		if ((i == 0) && (j == 0)) vector.addElement(ans);
		else {
			if ((i > 0) && (j == 0)) {
				calculateAllShortestPaths(matrix, "1" + ans, i - 1, 0);
			}
			else if ((i == 0) && (j > 0)) {
				calculateAllShortestPaths(matrix, "0" + ans, 0, j - 1);
			}
			else {
				int pathX = matrix[i][j - 1].price + matrix[i][j - 1].x;
				int pathY = matrix[i - 1][j].price + matrix[i - 1][j].y; 
				if (pathY > pathX) {
					calculateAllShortestPaths(matrix, "0" + ans, i, j - 1);
				}
				else if (pathY < pathX) {
					calculateAllShortestPaths(matrix, "1" + ans, i - 1, j);
				}
				else {
					calculateAllShortestPaths(matrix, "1" + ans, i - 1, j);
					calculateAllShortestPaths(matrix, "0" + ans, i, j - 1);	
				}
			}
		}
	}



	public static Node[][] initMatOfNodes(){ // n = 4 int n=4;
		Node mat[][] = new Node[4][4];
		mat[0][0] = new Node(1,3);
		mat[0][1] = new Node(8,4);
		mat[0][2] = new Node(3,8);
		mat[0][3] = new Node(0,4);

		mat[1][0] = new Node(2,5);
		mat[1][1] = new Node(5,11);
		mat[1][2] = new Node(3,1);
		mat[1][3] = new Node(0,2);

		mat[2][0] = new Node(4,10);		
		mat[2][1] = new Node(3,1);
		mat[2][2] = new Node(1,4);
		mat[2][3] = new Node(0,8);

		mat[3][0] = new Node(2,0);
		mat[3][1] = new Node(3,0);
		mat[3][2] = new Node(5,0);
		mat[3][3] = new Node(0,0); 
		return mat;
	}

	public static void main(String[] args) {
		Node[][] matrix = initMatOfNodes();
		Question3 test = new Question3(matrix);
		test.shortestPaths();
		test.calculateAllShortestPaths();
		for (Node[] arr : test.matrix) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i].price + ",\t");
			}
			System.out.println();
		}
		System.out.println(vector.toString());

		//Test belongs function///
		Node node1 = new Node(1, 0);
		Node node2 = new Node(1 ,1);
		Node node3 = new Node(2, 3);
		Node node4 = new Node(0, 1);
		Node node5 = new Node(2, 1);
		Node node6 = new Node(0, 0);
		Node node7 = new Node(3, 3);
		System.out.println("Node1 belongs? " + test.belongs(node1)); //--True
		System.out.println("Node2 belongs? " + test.belongs(node2)); //--True
		System.out.println("Node3 belongs? " + test.belongs(node3)); //--True
		System.out.println("Node4 belongs? " + test.belongs(node4)); //--True
		System.out.println("Node5 belongs? " + test.belongs(node5)); //--False
		System.out.println("Node6 belongs? " + test.belongs(node6)); //--True
		System.out.println("Node7 belongs? " + test.belongs(node7)); //--True
		Node[] array1 = {node1, node2, node3};
		Node[] array2 = {node1, node4};
		Node[] array3 = {node5, node4};
		System.out.println("Same path all nodes? " + test.allNodesBelong(array1));
		System.out.println("Same path all nodes? " + test.allNodesBelong(array2));
		System.out.println("Same path all nodes? " + test.allNodesBelong(array3));

	}
}

class Node{
	int x, y, price;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.price = 0;
	} 
}

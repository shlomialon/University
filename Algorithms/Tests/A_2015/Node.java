import java.util.ArrayList;

class Node{
	int x, y;
	int entry;
	int numOfPaths;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		entry = 0;
		numOfPaths = 1;
	}

	public static int numOfCheapestPaths; 
	public static int numOfOptimalPaths;
	public static int publicTeta;
	public static Node nodes[][] = initMatOfNodes();

	public static void Question3(Node[][] nodes, int teta){
		publicTeta = teta;
		nodes = initMatOfNodes();
		printMatrix(nodes);
		int n = nodes.length;
		int m = nodes[0].length;

		for (int i = 1; i < n; i++) {
			nodes[i][0].entry = nodes[i-1][0].entry + nodes[i-1][0].y;
			nodes[i][0].numOfPaths = 1;
		}
		for (int i = 1; i < m; i++) {
			nodes[0][i].entry = nodes[0][i-1].entry + nodes[0][i-1].x;
			nodes[0][i].numOfPaths = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int x = nodes[i][j-1].entry + nodes[i][j-1].x;
				int y = nodes[i-1][j].entry + nodes[i-1][j].y;
				nodes[i][j].entry = x <= y ? x : y;

				if(x < y)
					nodes[i][j].numOfPaths = nodes[i][j-1].numOfPaths;
				else if(y < x)
					nodes[i][j].numOfPaths = nodes[i-1][j].numOfPaths;
				else
					nodes[i][j].numOfPaths = nodes[i-1][j].numOfPaths + nodes[i][j-1].numOfPaths;
			}
		}
		numOfCheapestPaths = nodes[n-1][m-1].numOfPaths;
		numOfOptimalPaths = nodes[n-1][m-1].entry;
		
		System.out.println(numOfOptimalPaths());
		System.out.println(numOfCheapestPaths());
	} 

	public static int numOfCheapestPaths(){
		return numOfCheapestPaths;
	}

	public static int numOfOptimalPaths(){
		if(publicTeta <= numOfCheapestPaths){
			ArrayList<String> ans = getAllPaths(nodes);
			int count = 0;
			int k = 0;
			int num[] = new int[ans.size()];
			for (String str : ans) {
				for (int i = 1; i < str.length(); i++) {
					if(str.charAt(i-1) != str.charAt(i))
						count++;
				}
				num[k] = count;
				k++;
			}
			int max = num[0];
			for (int i = 1; i < num.length; i++) {
				if(num[i] > max)
					max = num[i];
			}
			int numOfOpt = 0;
			for (int i = 0; i < num.length; i++) {
				if(max == num[i])
					numOfOpt++;
			}
			return numOfOpt;
		}
		return -1;
	}

	public static ArrayList<String> getAllPaths(Node mat[][]){
		ArrayList<String> ans = new ArrayList<>();
		getAllPaths("",mat.length-1,mat[0].length-1,ans,mat);
		return ans;
	}

	private static void getAllPaths(String tmp, int i, int j, ArrayList<String> ans,Node mat[][]) {
		if(i == 0 && j == 0){
			ans.add(tmp);
			return;
		}
		if(i == 0 && j > 0){
			getAllPaths("0" + tmp,0,j-1,ans,mat);
		}
		if(j == 0 && i > 0)
			getAllPaths("1" + tmp,i-1,0,ans,mat);
		
		else{
		int x = mat[i][j-1].entry + mat[i][j-1].x;
		int y = mat[i-1][j].entry + mat[i-1][j].y;
		if(x < y)
			getAllPaths("0" + tmp,i,j-1,ans,mat);
		else if(y < x)
			getAllPaths("1" + tmp,i-1,j,ans,mat);
		else
			getAllPaths("1" + tmp,i-1,j,ans,mat);
			getAllPaths("0" + tmp,i,j-1,ans,mat);
	}
	}
	public static void printMatrix(Node mat[][]){
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j].x + " ");
			}
			System.out.println();
		}
		System.out.println();
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
	public static void main(String[] args) {
		Node mat[][] = null;
		Question3(mat,3);

	}
}

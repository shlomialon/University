package A_2016;

class Node{
	int x, y;
	int entry,numOfPaths;
	boolean isDead = false;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		entry = 0;
		numOfPaths = 0;
	}
}


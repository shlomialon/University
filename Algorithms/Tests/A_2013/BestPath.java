class Node {
	int x,y,entry,numOfPaths,entryFromTheEnd;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		entry = 0;
		entryFromTheEnd = 0;
		numOfPaths = 1;
	}
}
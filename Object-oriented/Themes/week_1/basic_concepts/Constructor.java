package basic_concepts;

public class Constructor {

	int length;
	int breadth;
	int height;
	
	Constructor() {
		length = 10;
		breadth = 10;
		height = 10;
	}
	
	Constructor(int l, int b, int h) {
		length = l;
		breadth = b;
		height = h;
	}
	
	public int getVolume() {
		return (length * breadth * height);
	}
	
	public static void main(String[] args) {
		Constructor cubeObj1, cubeObj2;
		cubeObj1 = new Constructor();
		cubeObj2 = new Constructor(10, 20, 30);
		System.out.println("Volume of Cube1 is : " + cubeObj1.getVolume());
		System.out.println("Volume of Cube1 is : " + cubeObj2.getVolume());
	}
}

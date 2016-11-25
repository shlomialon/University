
public class RingCollection {

	private Ring [] tring;
	public final int INIT_SIZE = 10;
	private int size;

	public RingCollection(){

		this.tring = new Ring [INIT_SIZE];
		this.size = 0;
	}

	public RingCollection(RingCollection col){

		this.tring = new Ring[this.tring.length];
		for (int i = 0; i < this.tring.length; i++) {
			this.tring[i] = col.tring[i];
		}
		this.size = col.size;
	}

	public int contains(Ring t){

		for (int i = 0; i < tring.length; i++) {
			if(this.tring[i].equals(t) == true)
				return i;
		}
		return -1;
	}

	public String ToString(){

		String ans = new String ();
		for (int i = 0; i < tring.length; i++) {
			ans += this.tring[i].toString()+", ";
		}
		return ans;
	}

	public void resizemore(Ring t){

		Ring[] temp = new Ring [tring.length + INIT_SIZE];
		int k = 0;
		for (int i = 0; i < tring.length; i++) {
			if(t.equals(this.tring[i]) == false){
				temp[k] = tring[i];	 
				k++;
			}
		}
		tring = temp;
	}

	public void addDifferent(Ring t){
		if(this.size == tring.length)
			resizemore(t);
		this.tring[size++] = new Ring(t);

	}

	public void remove(int index){
		for (int i = 0; i < tring.length; i++) {
			if(i == index){
				resizeless(tring[i]);
				break;
			}
		}
		size--;
	}

	public void resizeless(Ring t){

		Ring[] temp = new Ring [tring.length + INIT_SIZE];
		int k = 0;
		for (int i = 0; i < tring.length; i++) {
			if(t.equals(this.tring[i]) == false){
				temp[k] = tring[i];	 
				k++;
			}
		}
		tring = temp;
	}

	public static void main(String[] args) {

		/*
		Point p1 = new Point(2,3);
		Point p2 = new Point(2,4);
		Point p3 = new Point(2,5);
		Ring ring1 = new Ring(p1, 2 ,6);
		Ring ring2 = new Ring(p2, 2 ,6);
		Ring ring3 = new Ring(p3, 2 ,6);
		RingCollection [] rin = new RingCollection[3];
	
		for (int i = 0; i < rin.length; i++) {
			System.out.println(rin[i]);
		*/
		}
	}




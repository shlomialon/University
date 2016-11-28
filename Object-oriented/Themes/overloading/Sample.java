package overloading;

class DisplayOverloading{
	
	public void disp(char c, int num){
        System.out.println(c + " "+num);
    }
	
	public void disp(int num, char c){
        System.out.println(c + " "+num);
    }
	
}

class Sample{
	
   public static void main(String args[]){
	   DisplayOverloading obj = new DisplayOverloading();
       obj.disp('a',10);
       obj.disp(10, 'a');
   }
}

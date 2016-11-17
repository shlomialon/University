
public class reverseEncriptor extends inc_dic{

	public reverseEncriptor(int N){
		super(N);
	}

	public static String incNegtiveOne(String s){
		if(getN() == -1){
			String ans = "";	
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c == 'a'){
					int n = ((int)c + 25);
					ans += (char) n;
				} else{
					int n = (int)c - 1;
					ans += (char) n;
				}
			}
			return ans;
		}
		else return null;
	}

	public static void main(String[] args) {
		String ans = "aaab";
		System.out.println(incNegtiveOne(ans));
	}
}

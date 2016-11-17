
public class stepEncriptor extends inc_dic{

	public stepEncriptor(int N){
		super(N);
	}

	public static String incOne(String s){
		if(getN() == 1){
			String ans = "";	
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int n = (int)c +1;
				ans += (char) n;
			}
			return ans;
		}
		else return null;
	}
	/**public static void main(String[] args) {
		String s = "aaab";
		System.out.println(incOne(s));
	**/
	}


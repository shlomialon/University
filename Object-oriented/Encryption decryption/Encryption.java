<<<<<<< HEAD

public class Encryption implements encriptor{
	
	private static char C;
	
	public Encryption(char C){
		this.C = C;
	}
	
	public static char getC() {
		return C;
	}

	public void setC(char c) {
		C = c;
	}

	public static String encriptC(String s_e) {
		String ans = "";
		for (int i = 0; i < s_e.length(); i++) {
			char temp = (char) (getC() ^ s_e.charAt(i));
			ans += temp;
		}
		return ans;
	}
	
	
	public String encript(String s_e) {
		return encriptC(s_e);
	}

	public String[] encriptALL(String[] s_e) {
		for (int i = 0; i < s_e.length; i++) {
			encriptC(s_e[i]);
		}
		return s_e;
	}
	
	@Override
	public String decript(String s_d) {
		return encriptC(encript(s_d));
	}
	
	@Override
	public String[] decriptALL(String[] s_d) {
		for (int i = 0; i < s_d.length; i++) {
			encriptC(encriptC(s_d[i]));
		}
		return s_d;
	}
}
=======

public class Encryption implements encriptor{
	
	private static char C;
	
	public Encryption(char C){
		this.C = C;
	}
	
	public static char getC() {
		return C;
	}

	public void setC(char c) {
		C = c;
	}

	public static String encriptC(String s_e) {
		String ans = "";
		for (int i = 0; i < s_e.length(); i++) {
			char temp = (char) (getC() ^ s_e.charAt(i));
			ans += temp;
		}
		return ans;
	}
	
	
	public String encript(String s_e) {
		return encriptC(s_e);
	}

	public String[] encriptALL(String[] s_e) {
		for (int i = 0; i < s_e.length; i++) {
			encriptC(s_e[i]);
		}
		return s_e;
	}
	
	@Override
	public String decript(String s_d) {
		return encriptC(encript(s_d));
	}
	
	@Override
	public String[] decriptALL(String[] s_d) {
		for (int i = 0; i < s_d.length; i++) {
			encriptC(encriptC(s_d[i]));
		}
		return s_d;
	}
}
>>>>>>> 323d3bf833cc672933e09df82e17c05aeb5cb374

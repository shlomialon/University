package LIS;

import java.util.Vector;

class AllSubString {
	
	public static Vector<String> SubString(Vector<Character> v){
		Vector<String> ans = new Vector<>();
		int size = 0;
		for (int i = 0; i < v.size(); i++) {
			for (int j = 0; j < size; j++) {
				ans.addElement(ans.elementAt(j) + "" + v.elementAt(i));
			}
			ans.addElement(v.elementAt(i) + "");
			size = ans.size();
		}
		return ans;
	}

	
	public static void main(String[] args) {
		/**
		String str = "abc";
		Vector<Character> v = new Vector<>();
		for (int i = 0; i < str.length(); i++) {
			v.add(str.charAt(i));
		}
		System.out.println(v.toString());		
		System.out.println(SubString(v));	
		**/
		
	}
}
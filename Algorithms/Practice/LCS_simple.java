class LCS_simple{

	private static String largestInter (String a, String b) {

		String ans = "";
		int start = 0;
		for (int i=0; i<a.length(); i++) {
			int index = b.indexOf(a.charAt(i),start);
			if (index != -1) {
				ans += a.charAt(i);
				start = index +1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
        System.out.println(largestInter("adaaa", "aldaaavvcasecasclavbaadabdcf"));
	}
}


import java.util.Vector;

/**
 * Created by Shlomi Alon on 18/12/2016.
 */
public class LCS {
    //O(m*n)
    public static String greedyLCS(String x, String y) {
        String ans = "";
        int start = 0;
        for (int i = 0; i < x.length(); i++) {
            int index = y.indexOf(x.charAt(i), start);
            if (index != -1) {
                ans += x.charAt(i);
                start = index + 1;
            }
        }
        return ans;
    }

    //O(m*n)
    public static String greedyLCSImproved(String x, String y) {
        int freq[] = new int[26];
        for (int i = 0; i < x.length(); i++) {
            int insert = (x.charAt(i) - 'a');
            freq[insert]++;
            System.out.println(freq[insert]);
        }
        String ans = "";
        int start = 0;
        for (int i = 0; i < y.length(); i++) {
            int insert = (y.charAt(i) - 'a');
            if (freq[insert] > 0) {
                int index = y.indexOf(x.charAt(i), start);
                if (index != -1) {
                    ans = ans + y.charAt(i);
                    start = index + 1;
                }
            }
            freq[insert]--;
        }
        return ans;
    }

    //O(2^(n+m)*min(n,m))
    public static String wholeSearch(String x, String y) {
        Vector<String> vx = getAllSubStrings(x);
        Vector<String> vy = getAllSubStrings(y);
        String lcs = "";
        for (String s1:vx) {
            for (String s2:vy) {
                if(s1.equals(s2)) {
                    if (s1.length() > lcs.length()) {
                        lcs = s1;
                    }
                }
            }
        }
        return lcs;
    }

    private static Vector<String> getAllSubStrings(String str) {
        Vector<String> ans = new Vector<>();
        getAllSubStrings(str, ans, 0, "");
        return ans;
    }

    private static void getAllSubStrings(String str, Vector<String> ans, int i, String temp) {
        if (str.length() == i) {
            ans.add(temp);
            return;
        }
        getAllSubStrings(str, ans, i + 1, temp);
        getAllSubStrings(str, ans, i + 1, temp + str.charAt(i));
    }
    //O(n*m)
    public static int LCS_length(String x, String y) {
        int n = x.length() + 1;
        int m = y.length() + 1;
        int matrix [][] = new int [n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[n-1][m-1];
    }

    public static int[][] LCS_mat(String x, String y) {
        int n = x.length() + 1;
        int m = y.length() + 1;
        int matrix [][] = new int [n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix;
    }

        public static String LCS_string(String x, String y) {
            int[][] matrix = LCS_mat(x,y);
            int len = LCS_length(x,y);
            int i = x.length();
            int j = y.length();
            String ans ="";
            while(len>0) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    ans = ans + x.charAt(i - 1);
                    i--;
                    j--;
                    len--;
                } else {
                    if (matrix[i - 1][j] > matrix[i][j - 1]) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
        System.out.println(LCS_string("abcsefg" , "bcegq"));
    }
}

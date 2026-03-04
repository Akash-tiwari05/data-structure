package string.toPointer;

public class IsSubsequence {

    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();
        int left = 0;
        int right = 0;
        while(left < m && right < n){
            if(s.charAt(left) == t.charAt(right)){
                left++;
            }
            right++;
        }
        return left == m;
    }
}

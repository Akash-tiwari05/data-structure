package string.toPointer;

public class RemovePalindromicSubsequences {
    public static void main(String[] args) {

        String s = "ababa";
        System.out.println(removePalindromeSub(s));
    }

    public static int removePalindromeSub(String s) {

        if(s.isBlank()) return 0;
        if(isPalindrome(s)) return 1;
        return 2;
    }

    private static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

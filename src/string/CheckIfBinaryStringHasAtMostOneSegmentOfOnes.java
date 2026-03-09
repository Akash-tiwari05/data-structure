package string;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public static void main(String[] args) {
        String s = "1001";
    }

    public static boolean checkOnesSegment(String s) {

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '1' && s.charAt(i-1) =='0'){
                return false;
            }
        }
        return true;
    }
}

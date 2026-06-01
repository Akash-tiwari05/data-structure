package backtracking;

public class LargestNumberInKSwaps {

    public static void main(String[] args) {

        String s = "3435335"; //number
        int k = 3; //swaps
        System.out.println(findMaximumNum(s,k));
    }

    public static String findMaximumNum(String s, int k) {
        // code here.
        //char[] digits = s.toCharArray();
        StringBuilder res = new StringBuilder(s);
        helper(new StringBuilder(s),k, res, 0);
        return res.toString();
    }
    private static void helper(StringBuilder s,int k, StringBuilder res,
                               int start){

        if(k == 0 || start == s.length()){

            return;
        }

        char maxNum = s.charAt(start);
        for (int i = start+1; i < s.length() ; i++) {
            if(maxNum < s.charAt(i)){
                maxNum = s.charAt(i);
            }
        }

        for (int i = start; i < s.length() ; i++) {

            //if(start == i || digits[start] >= digits[i]) continue;
            if(s.charAt(i) == maxNum && i != start){
                swap(s,start,i);
                if (s.compareTo(res) > 0) {
                    res.setLength(0);
                    res.append(s);
                }
                helper(s, k-1, res,start+1);
                swap(s,start,i);
            }

        }
        helper(s,k,res,start+1);

    }
    private static void swap(StringBuilder s, int index, int i){
        char temp = s.charAt(index);
        s.setCharAt(index, s.charAt(i));
        s.setCharAt(i,temp);
    }
}

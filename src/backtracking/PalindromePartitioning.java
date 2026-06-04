package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> palindrome = new ArrayList<>();
        checkAllPalindrome(0,s,new ArrayList<>(), result);
        return result;
    }

    private static void checkAllPalindrome(int index, String s,
                                           List<String> currentPartition,
                                           List<List<String>> result){

        if(index == s.length()){
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            String current = s.substring(index,i+1);
            if(isPalindrome(current)){
                currentPartition.add(current);

                checkAllPalindrome(i+1,s,currentPartition,result);
                currentPartition.remove(currentPartition.size()-1);
            }
            //checkAllPalindrome(index+1,s,palindrome,allPalindromes);
        }


    }

    private static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

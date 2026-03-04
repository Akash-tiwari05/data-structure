package string.toPointer;

import java.util.Arrays;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int left = 0;
        int right = words.length-1;
        while(left < right){
            String temp = words[right];
            words[right] = words[left];
            words[left] = temp;
            left++;
            right--;
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if(i < words.length-1){
                sb.append(" ");
            }
        }
        //System.out.println(Arrays.toString(words));
        return sb.toString();
    }
}

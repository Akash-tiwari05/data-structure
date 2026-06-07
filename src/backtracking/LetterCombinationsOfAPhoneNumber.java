package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {

        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static final String[] KEYS = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    /*public static List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> list = new ArrayList<>();
        helper(0,digits,new StringBuilder(""),list, map);
        return list;
    }*/

    public static List<String> letterCombinations(String digits) {


        List<String> result = new ArrayList<>();

        helper(0,digits,new StringBuilder(""),result);
        return result;
    }

    private static void helper(int index, String digits, StringBuilder phone,
                               List<String> list){

        if(index == digits.length()){
            list.add(phone.toString());
            return;
        }

        String letters = KEYS[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            phone.append(letters.charAt(i));

            helper(index + 1, digits, phone, list);

            phone.setLength(phone.length() - 1);
        }
    }
}

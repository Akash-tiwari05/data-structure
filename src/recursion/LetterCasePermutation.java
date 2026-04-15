package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {

        System.out.println(letterCasePermutation("3z4"));
    }

    public static List<String> letterCasePermutation(String s) {

        List<String> list = new ArrayList<>();
        cases(s,"",list);
        return list;
    }

    public static void cases(String ip, String op, List<String> list){

        if(ip.isEmpty()){
            list.add(op);
            return;
        }
        char ch = ip.charAt(0);

        String rem = ip.substring(1);
        if(Character.isDigit(ch)){
            cases(rem,op+ch,list);
        }else{
            cases(rem,op+Character.toLowerCase(ch),list);
            cases(rem,op+Character.toUpperCase(ch),list);
        }

    }

}

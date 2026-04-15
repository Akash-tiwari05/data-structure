package recursion;

import java.util.ArrayList;

public class PermutationWithSpaces {

    public static void main(String[] args) {
        System.out.println(permutation("ABC"));
    }

    static ArrayList<String> permutation(String s) {
        // Code Here
        ArrayList<String> list = new ArrayList<>();
        char ch = s.charAt(0);
        String op = ""+ch;
        String ip = s.substring(1);
        helper(ip,op,list);
        return list;
    }

    static void helper(String ip, String op, ArrayList<String> list){

        if(ip.isEmpty()){
            list.add(op);
            return;
        }

        String with  =" "+ ip.charAt(0);
        String without = ""+ip.charAt(0);

        String remaining = ip.substring(1);

        helper(remaining,op+with,list);
        helper(remaining,op+without,list);

    }
}

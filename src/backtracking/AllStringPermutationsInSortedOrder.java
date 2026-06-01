package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AllStringPermutationsInSortedOrder {

    public static void main(String[] args) {

        String s = "AAB";
        System.out.println(permutation(s));
    }

    public static ArrayList<String> permutation(String s) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        solve(0,new StringBuilder(s),list);
        //solve2(new StringBuilder(s),"",list);
        Collections.sort(list);
        return list;
    }

    //backtracking
    private static void solve(int index, StringBuilder s,
                              ArrayList<String> res) {
        if(index == s.length()){
            res.add(s.toString());
            return;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) continue;
            map.put(ch,0);
            swap(s,index,i);
            solve(index+1,s,res);

            //backtracking
            swap(s,index,i);
        }

    }

    private static void swap(StringBuilder s, int index, int i){
        char temp = s.charAt(index);
        s.setCharAt(index, s.charAt(i));
        s.setCharAt(i,temp);
    }

    //recursion
    private static void solve2(StringBuilder ip, String op,
                              ArrayList<String> res) {
        if(ip.isEmpty()){
            if(!op.isEmpty()){
                res.add(op);
            }
            return;
        }

        for (int i = 0; i < ip.length(); i++) {

            char ch = ip.charAt(i);
            // create new input without current char
            StringBuilder newIp = new StringBuilder(ip);
            newIp.deleteCharAt(i);

            // create new output
            String newOp = op + ch;

            solve2(newIp, newOp, res);
        }

    }

}

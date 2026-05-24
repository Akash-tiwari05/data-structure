package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class AllStringPermutationsInSortedOrder {

    public static void main(String[] args) {

        String s = "ABC";
        System.out.println(permutation(s));
    }

    public static ArrayList<String> permutation(String s) {
        // code here
        ArrayList<String> list = new ArrayList<>();

        //solve(0,new StringBuilder(s),list);
        solve2(s.length(),s,"",list);
        Collections.sort(list);
        return list;
    }

    private static void solve(int index, StringBuilder s,
                             ArrayList<String> res) {
        if(index == s.length()){

        }

    }

    //recursion
    private static void solve2(int n, String ip, String op,
                              ArrayList<String> res) {
        if(n == 0){
            if(!op.isEmpty()){
                res.add(op);
            }
            return;
        }

        char ch = ip.charAt(n-1);

        String rem = ip.substring(0,n);

        solve2(n-1,rem,op+ch,res);
        solve2(n-1,rem,op,res);

    }

}

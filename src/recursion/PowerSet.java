package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static recursion.Subset.list;

public class PowerSet {
    public static void main(String[] args) {


        System.out.println(AllPossibleStrings("abc"));
    }

    public static List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> list = new ArrayList<>();
        subset(s,"",list);
        Collections.sort(list);
        return list;
    }

    public static void subset(String ip, String op,List<String> list){

        if(ip.isEmpty()){
            if(!op.equals("")){
                list.add(op);
            }
            return;
        }

        char ch = ip.charAt(0);
        String remaining = ip.substring(1);

        // not include
        subset(remaining,op,list);

        //include
        subset(remaining,op+ch,list);
    }
}

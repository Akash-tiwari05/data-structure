package recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubset {

    public static void main(String[] args) {

        String ip = "aab";
        String op = "";
        HashSet<String> set = new HashSet<>();
        subset(set,ip,op);
        System.out.println(set);
    }

    public static void subset(HashSet<String> set, String ip, String op){

        if(ip.isEmpty()){
            set.add(op);
            return;
        }

        char ch = ip.charAt(0);
        String remaining = ip.substring(1);

        // not include
        subset(set,remaining,op);

        //include
        subset(set,remaining,op+ch);
    }
}

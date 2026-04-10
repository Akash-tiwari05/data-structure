package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {

        subset("abc","");
        Collections.sort(list);
        System.out.println(list);
    }

    public static void subset(String ip, String op){

        if(ip.isEmpty()){
            list.add(op);
            return;
        }

        char ch = ip.charAt(0);
        String remaining = ip.substring(1);

        // not include
        subset(remaining,op);

        //include
        subset(remaining,op+ch);
    }
}

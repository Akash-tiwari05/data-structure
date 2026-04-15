package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        solve(0,0,n,"",list);
        return list;
    }

    public static void solve(int open, int cl,int n, String op, List<String> list){

        int m = op.length();
        if(m == 2*n){
            list.add(op);
            return;
        }

        if(open < n){
            solve(open +1,cl,n,op+"(",list);
        }
        if(cl < open){
            solve(open,cl +1,n,op+")",list);
        }

    }
}

package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNBitBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(NBitBinary(3));
    }

    static ArrayList<String> NBitBinary(int N) {
        // code here

        ArrayList<String> list = new ArrayList<>();
        solve(0,0,N,"",list);
        return list;
    }

    static void solve(int one, int zero,int n, String op, ArrayList<String> list){

        int m = op.length();
        if(m == n){
            list.add(op);
            return;
        }

        if(one < n){
            solve(one +1,zero,n,op+"1",list);
        }
        if(zero < one){
            solve(one,zero +1,n,op+"0",list);
        }

    }
}

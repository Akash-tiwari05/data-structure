package recursion;

public class kthSymbolInGrammar {

    public static int kthGrammar(int n, int k) {

        if(n == 1 && k == 1){
            return 0;
        }

        int len = 1 << (n-1);
        int mid = len/2;

        if(k <= mid){
            return kthGrammar(n-1,k);
        }
        else{
            // Inverted value from previous row
            return 1 -kthGrammar(n-1,k-mid);
        }
    }

    public static void main(String[] args) {

        System.out.println(kthGrammar(2,2));
    }
}

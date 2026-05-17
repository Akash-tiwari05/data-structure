package dynamicPrograming.matrixChain;

//egg dropping problems
public class SuperEggDrop {

    public static void main(String[] args) {

        int n = 2, k = 36;
        System.out.println(eggDrop(n,k));
    }

    //k == floor  and n == egg
    static int eggDrop(int n, int k) {
        // code here

        if(n == 1 || k <= 1) return k;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {

            int eggBreak = eggDrop(n-1,k-1);
            int notBreak = eggDrop(n,k-i);

            int temp = Math.min(eggBreak,notBreak);
            ans = Math.min(temp,ans);
        }
        return ans;
    }
}

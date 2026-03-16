package maths.numberTheory;

public class NumberOfFactors {

    public static void main(String[] args) {
        System.out.println(countFactors(25));
    }

    static int countFactors(int n) {
        // code here
        int count = 0;
        for (int i = 1; i*i <= n ; i++) {
            if(n % i == 0){
                count ++;
                if( i != n/i){
                    count++;
                }
            }
        }

        return count;
    }
}

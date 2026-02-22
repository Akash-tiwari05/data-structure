package maths.divisiors;

public class SumOfFactors {

    public static void main(String[] args) {
        System.out.println(sumOfFactors(30));
    }

    public static long sumOfFactors(int n){

        long totalFactors = 1;
        for (int i = 2; i*i <= n ; i++) {
            int count = 0;
            while (n%i == 0 && n != 0){
                count++;
                n /= i;
            }

            if(count >0){
                totalFactors *= (int)(Math.pow(i,count+1) -1)/(i-1);
            }
        }
        // Handle leftover prime
        if (n > 1) {
            totalFactors *= (Math.pow(n, 2) - 1) / (n - 1);
        }
        return totalFactors;
    }
}

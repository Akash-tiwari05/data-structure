package maths.divisiors;

public class ProductOfFactors {

    public static void main(String[] args) {
        System.out.println(productOfFactors(6));
    }

    public static long productOfFactors(int n){
        long originalN = n;
        long totalFactors = 1;
        for (int i = 2; i*i <=n ; i++) {
            int count = 0;
            while (n % i == 0){
                count++;
                n /= i;
            }
            totalFactors *= (count +1);
        }

        //remaining value of n
        if(n > 1){
            totalFactors *= 2;
        }

        long product = (long) Math.pow(originalN,totalFactors/2);
        return product;
    }
}

package maths.divisiors;

public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {

        if(n < 2) return 0;
        int count = 0;
        for (int i = 2; i < n ; i++) {
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n){

        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

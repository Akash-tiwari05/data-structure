package maths.divisiors;

public class NumberOfFactors {

    public static void main(String[] args) {

        System.out.println("Brute force solution = "+numOfFactors(84));

        System.out.println("-".repeat(50));
        System.out.println("Optimal Solution = "+ numOfFactors2(84));
    }


    //this is brute force
    public static int numOfFactors(int n){

        int totalFactors = 1;
        for (int i = 2; i <= n ; i++) {
            int count = 0;
            while (n % i == 0){
                count++;
                n /= i;
            }
            totalFactors *= (count+1);
        }
        return  totalFactors;
    }

    //this is optimal solution
    public static int numOfFactors2(int n){

        int totalFactors = 1;
        for (int i = 2; i*i <= n ; i++) {
            int count = 0;
            while (n % i == 0){
                count++;
                System.out.print(i +"->");
                n /= i;

            }
            totalFactors *= (count+1);
        }

        if(n > 1) totalFactors *= 2;
        return  totalFactors;
    }
}

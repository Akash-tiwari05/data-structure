package maths.numberTheory;

public class Factorial {

    public static void main(String[] args) {

        System.out.println(factorial(5));

    }

    public static int factorial(int n) {
        // code here
        if(n < 2) return 1;
        return n*factorial(n-1);
    }
}

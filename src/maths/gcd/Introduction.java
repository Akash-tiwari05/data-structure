package maths.gcd;

public class Introduction {

    public static void main(String[] args) {
        System.out.println("Brute = "+gcd(36, 60));
        System.out.println("Using subtract operator = "+gcd2(36, 60));
        System.out.println("Using subtract operator + not recursion = "+
                gcd3(11, 5));
    }

    //brute force;
    public static int gcd(int a, int b){

        int gcd = 1;
        for (int i = 2; i <= Math.min(a,b); i++) {
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    //euclidean algo using subtract operator;
    public static int gcd2(int a, int b){

        if(a == 0) return b;
        if(a >= b){
            a -= b;
        }else{
            b -= a;
        }
        return gcd(a,b);
    }

    //euclidean algo using subtract operator but not recursion;
    public static int gcd3(int a, int b){
        while (a > 0){
            if(a >= b){
                a -= b;
            }else{
                b -= a;
            }
        }
        return b;
    }
}

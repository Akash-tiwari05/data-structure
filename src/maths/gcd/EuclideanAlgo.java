package maths.gcd;

import com.sun.security.jgss.GSSUtil;

public class EuclideanAlgo {

    public static void main(String[] args) {
        System.out.println("EuclideanAlgo: "+gcd(36,60));
        System.out.println("EuclideanAlgo: "+gcd2(36,60));
        System.out.println("Using Recursion EuclideanAlgo: "+gcd2(36,60));
    }

    public static int gcd(int a, int b){

        while (a >0 && b > 0){
            if(a >= b){
                a %= b;
            }else{
                b %= a;
            }
        }
        return (a == 0) ? b : a;
    }

    public static int gcd2(int a, int b){

        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd3(int a, int b){

        return (b == 0) ? a: gcd3(b,a%b);
    }
}

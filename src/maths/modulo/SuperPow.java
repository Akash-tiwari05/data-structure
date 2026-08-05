package maths.modulo;

public class SuperPow {

    public static void main(String[] args) {

        int[] b = {1,0};
        int a = 2;

        System.out.println(superPow(a,b));
        System.out.println(modulo(a,7,6));
    }

    public static int superPow(int a, int[] b) {

        a %= 1337;
        int result = 1;

        int n = b.length;

        while (n > 0){
            n--;
        }

        return (int) result;

    }

    //brute force a^b % m
    public static int modulo(int a, int b,int m){

        int res = 1;
        a %= m;

        for (int i = 1; i <= b ; i++) {
            res =res* a % m;
        }

        return res;
    }

}

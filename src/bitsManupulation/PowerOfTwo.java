package bitsManupulation;

public class PowerOfTwo {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo2(16));
        System.out.println(isPowerOfTwo(16));
    }

    //brute force;
    public static boolean isPowerOfTwo2(int n) {

        if(n < 0) return false;
        for (int i = 0; i < 30; i++) {
            if((1 << i) == n){
                return true;
            }
        }
        return false;
    }

    //solution without loops/recursion?
    public static boolean isPowerOfTwo(int n) {

        return n > 0 && ((n & n-1) == 0);
        //16 = 10000 &
        //15 = 01111
        //ans = 00000
    }
}

package bitsManupulation;

public class CheckOdd {

    public static void main(String[] args) {
        //check odd number using bit operator
        System.out.println(isOdd(25));
    }

    public static boolean isOdd(int n){

        if((n & 1) == 1) return true;
        return false;
    }

    public static boolean isEven(int n){

        if((n & 1) == 0) return true;
        return false;
    }
}

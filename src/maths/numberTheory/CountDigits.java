package maths.numberTheory;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(count(245));
    }

    public static int count(int n){
        int count = 0;
        while( n > 0){
            count++;
            n /= 10;
        }
        return count;
    }
}

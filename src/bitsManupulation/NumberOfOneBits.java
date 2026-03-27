package bitsManupulation;

public class NumberOfOneBits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(2147483645));
        System.out.println(hammingWeight2(2147483645));
    }

    //brute force
    public static int hammingWeight(int n) {

        int count = 0;
        while (n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    //optimal solution
    public static int hammingWeight2(int n) {

        int setBits = 0;
        while (n > 0){
            setBits++;
            n = n& n-1;
        }
        return setBits;
    }
}

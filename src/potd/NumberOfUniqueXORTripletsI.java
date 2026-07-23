package potd;

public class NumberOfUniqueXORTripletsI {

    public static void main(String[] args) {

        int[] arr = {3,1,2};
        System.out.println(uniqueXorTriplets(arr));
    }

    public static int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if (n < 3) {
            return n;
        }

        int bits = 32 - Integer.numberOfLeadingZeros(n);
        return 1 << bits;
    }
}

package potd;

public class ConstructUniformParityArrayII {

    public static boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        // Step 1: Find the smallest odd number
        for (int num : nums1) {
            if (num % 2 != 0) {
                if (num < minOdd) {
                    minOdd = num;
                }
            }
        }

        // Step 2: If there are no odd numbers, the array is already all even (True)
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Step 3: If there are odd numbers, every even number must be > minOdd
        for (int num : nums1) {
            if (num % 2 == 0) {
                if (num < minOdd) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7};
        System.out.println(uniformArray(nums1)); // Output: true

        int[] nums2 = {2, 3};
        System.out.println(uniformArray(nums2)); // Output: false
    }
}

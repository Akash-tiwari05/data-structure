package prefixsum;

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] arr = {-4,-3};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {

        int leftProd = 1;
        int n = nums.length;
        int maxProd = nums[0];
        for (int i = 0; i < n; i++) {
            leftProd *= nums[i];
            maxProd = Math.max(maxProd,leftProd);
            if (leftProd == 0) {
                leftProd = 1;
            }
        }

        int rightProd = 1;
        for (int i = n-1; i >= 0 ; i--) {
            rightProd *= nums[i];
            maxProd = Math.max(maxProd,rightProd);
            if(rightProd== 0){
                rightProd =1;
            }
        }
        return maxProd;
    }
}

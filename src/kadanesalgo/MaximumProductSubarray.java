package kadanesalgo;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};

        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {

        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for(int i= 1; i < nums.length; i++){
            int ele = nums[i];
            int tempMax = Math.max(ele, Math.max(maxProd* ele, minProd*ele));
            int tempMin = Math.min(ele,Math.min(maxProd* ele, minProd*ele));

            maxProd = tempMax;
            minProd = tempMin;
            res = Math.max(maxProd,res);
        }
        return res;
    }
}

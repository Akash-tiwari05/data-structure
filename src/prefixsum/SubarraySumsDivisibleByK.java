package prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {

        int[] arr= {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(arr,k));
    }

    public static int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        int totalSum = 0;
        int count = 0;
        for(int num : nums){
            totalSum += num;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            int rem= totalSum - nums[i];
            int ans = rem%k;
            if(ans == 0){
                map.get(ans);
            }
            if(map.containsKey(k - nums[i])){
                count += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
        }

        return count;
    }
}

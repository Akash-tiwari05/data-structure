package prefixsum;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        System.out.println(subarraySum(arr,k));
    }

    public static int subarraySum(int[] nums, int k) {

        int n= nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            sum += nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

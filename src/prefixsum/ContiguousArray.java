package prefixsum;

import java.util.HashMap;

public class ContiguousArray {

    public static void main(String[] args) {

        int[] arr = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {

        /*
        mc = Math.max(mc, i-  mp.get(ps));
                                      mp = (0, -1)
        i = 0, n = 0. ps =-1, mc = 0, mp = (-1, 1)
        i = 1, n = 1, ps = 0, mc = 2, mp = (0, 2)
        i = 2, n=  1, ps = 1, mc = 2, mp = (1, 2)
        i = 3, n=  1, ps = 2, mc = 2, mp = (2, 3)
        i = 4, n=  1, ps = 3, mc = 2, mp = (3, 4)
        i = 5, n=  1, ps = 4, mc = 2, mp = (4, 5)
        i = 6, n=  1, ps = 5, mc = 2, mp = (5, 6)
        i = 7, n=  0, ps = 4, mc = 2, mp = (4, 5)
        i = 8, n=  0, ps = 3, mc = 4, mp = (3, 4)
        i = 9, n=  0, ps = 2, mc = 6, mp = (2, 3)
         */


        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxCount = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += (nums[i] == 0) ? -1: 1;
            if(map.containsKey(prefixSum)){
                maxCount = Math.max(maxCount, i- map.get(prefixSum));
            }else{
                map.put(prefixSum,i);
            }

        }
        return maxCount;
    }
}

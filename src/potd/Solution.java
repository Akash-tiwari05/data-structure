package potd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class Fenwick {
        long[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void add(int idx, long val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long sum(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long[] vals = pref.clone();
        Arrays.sort(vals);

        Map<Long, Integer> rank = new HashMap<>();
        int id = 1;
        for (long v : vals) {
            if (!rank.containsKey(v)) {
                rank.put(v, id++);
            }
        }

        Fenwick bit = new Fenwick(id - 1);

        long ans = 0;

        for (long p : pref) {
            int r = rank.get(p);
            ans += bit.sum(r - 1);
            bit.add(r, 1);
        }

        return (int) ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 3};
        int target1 = 2;
        System.out.println(sol.countMajoritySubarrays(nums1, target1)); // 5

        int[] nums2 = {1, 1, 1, 1};
        int target2 = 1;
        System.out.println(sol.countMajoritySubarrays(nums2, target2)); // 10

        int[] nums3 = {1, 2, 3};
        int target3 = 4;
        System.out.println(sol.countMajoritySubarrays(nums3, target3)); // 0
    }
}

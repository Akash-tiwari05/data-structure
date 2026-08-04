package potd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMissingElements {

    public static void main(String[] args) {
        int[]  nums = {1,4,2,5};
    }

    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}

package sorting.introduction;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthElement {

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.reverseOrder());
        for (int ele: nums) {
            pq.add(ele);
            if(pq.size() > k){
                pq.poll();
            }

        }

        return pq.peek();
    }
}

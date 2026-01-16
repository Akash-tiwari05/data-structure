package slidingWindow;

import java.util.*;

public class KSizedSubarrayMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(maxOfSubarrays(arr,3));
    }
    //this solution is valid for gfg
    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n){

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);

            if((j - i + 1) == k){
                list.add(arr[dq.peekFirst()]);
                if(!dq.isEmpty() && dq.peekFirst() < i) {
                    dq.pollFirst();
                }


                i++;
            }
            j++;
        }
        return list;
    }

    //this solution only valid for LeetCode
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        // I use this doubly queue for maintaining my Monotonic decreasing queue
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n){

            while(!q.isEmpty() && nums[q.peekLast()] < nums[j]){
                q.pollLast();
            }

            q.offerLast(j);

            if(j - i +1 == k){
                arr[i] = nums[q.peekFirst()];

                if(!q.isEmpty() && q.peekFirst() == i){
                    q.pollFirst();
                }

                i++;
            }
            j++;
        }
        return arr;
    }
}

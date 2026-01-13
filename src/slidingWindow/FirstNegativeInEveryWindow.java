package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindow {
    public static void main(String[] args) {
        int[] arr= {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println("Brute force = "+firstNegInteger(arr, 3));
        System.out.println("Optimal Solution = "+firstNegInt(arr, 3));
    }

    //brute force solution
    public static List<Integer> firstNegInteger(int arr[], int k){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length - k +1; i++){
            int firstNegative = 0;
            for(int j = i; j < i+k; j++){
                if(arr[j] < 0){
                   firstNegative = arr[j];
                    break;
                }
            }
            ans.add(firstNegative);
        }
        return ans;
    }

    //optimal solution using sliding window
    public static List<Integer> firstNegInt(int arr[], int k){
        //Array -> Subarray -> firstNegative -> window size
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();


        int n = arr.length;
        int i = 0, j = 0;
        while(j < n){
            if(arr[j] < 0){
                queue.add(j);
            }
            int sum = j - i +1;
            if(sum == k){
                if(!queue.isEmpty()){
                    list.add(arr[queue.peek()]);
                }else{
                    list.add(0);
                }

                if(!queue.isEmpty() && queue.peek() == i){
                    queue.poll();
                }
                i++;
            }
            j++;
        }
        return list;
    }
}

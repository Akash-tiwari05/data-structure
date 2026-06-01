package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0,nums,ans,list);
        return ans;
    }

    private static void solve(int idx, int[] arr,
                              List<List<Integer>> ans, List<Integer> list) {

        if (idx == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr,idx,i);

            list.add(arr[idx]);

            solve(idx +1, arr, ans,list);

            //backtracking
            list.remove(list.size()-1);

            swap(arr,idx,i);
        }

    }

    private static void swap(int[] arr, int i, int j){

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

    }
}

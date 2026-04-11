package recursion;

import java.util.Arrays;

public class SortAnArrayUsingRecursion {

    public static void main(String[] args) {

        int[] arr = {2,3,7,6,4,5,9};
        int n = arr.length;
        sortedArray(arr,n);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortedArray(int[] arr, int n){
        //base case
        if(n <= 1){
            return;
        }

        int last = arr[n-1];
        //hypothesis
        sortedArray(arr,n-1);
        //induction
        insert(arr,n-1, last);
    }

    public static void insert(int[] arr, int n, int ele){

        //base cae;
        if(n == 0 || arr[n-1] <= ele){
            arr[n] = ele;
            return;
        }

        int last = arr[n-1];
        arr[n] = last;

        insert(arr, n - 1, ele);
    }
}
/*
*
* sortedArray(arr,5)
  → sortedArray(arr,4)
      → sortedArray(arr,3)
          → sortedArray(arr,2)
              → sortedArray(arr,1)  ✅ base case
*
* */
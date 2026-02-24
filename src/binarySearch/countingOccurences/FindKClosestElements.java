package binarySearch.countingOccurences;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int k =  4;
        int x = 3;
        System.out.println(findClosestElements(arr,k,x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int low = 0;
        int high = n-k;
        while (low < high){
            int mid = low + (high - low)/2;
            if ((x - arr[mid]) > (arr[mid+k] - x  )){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        for (int i = low; i < low + k; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}

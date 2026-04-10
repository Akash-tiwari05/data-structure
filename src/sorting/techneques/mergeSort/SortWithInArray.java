package sorting.techneques.mergeSort;

import java.util.Arrays;

public class SortWithInArray {

    public static void main(String[] args) {

        int[] arr = {1,3,4,2,5,6,8};
        int k = 2;
        merge(arr,k);
    }

    public static void merge(int[] arr, int k){
        int n = arr.length;

        /*int l = 0;
        int r = n-1;*/

        //short an array from l - k && k+1 - n
        int p1 = 0;
        int p2 = k+1;

        int[] temp = new int[n];
        int i = 0;
        while (p1 <=k  && p2 < n){
            if(arr[p1] <= arr[p2]){
                temp[i] = arr[p1];
                p1++;
            }else{
                temp[i] = arr[p2];
                p2++;
            }
            i++;
        }

        while (p1 <= k){
            temp[i] = arr[p1];
            i++;
            p1++;
        }

        while(p2 < n){
            temp[i] = arr[p2];
            p2++;
            i++;
        }
        System.out.println(Arrays.toString(temp));
    }
}

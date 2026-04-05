package sorting.techneques.insertionSort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //int[] arr = {6,2,4,1,9};

        int[] ans = insertionSort2(n, arr);
        System.out.println(Arrays.toString(ans));
    }

    //my solution
    public static int[] insertionSort(int n, int[] arr){

        for(int i = 1; i < n; i++){
            int curr = arr[i];
            for(int j = i-1; j >= 0; j--){
                if(arr[j] > curr){
                    arr[j+1] = arr[j];
                    arr[j] = curr;
                }
            }
        }
        return arr;
    }

    //standard solution
    public static int[] insertionSort2(int n, int[] arr){

        for(int i = 1; i < n; i++){
            int curr = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
        return arr;
    }
}

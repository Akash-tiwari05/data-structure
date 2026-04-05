package sorting.techneques.selectionSort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    //int[] arr = {6,2,4,1,9};

    int[] ans = selectionSort(n, arr);
    System.out.println(Arrays.toString(ans));
}

    public static int[] selectionSort(int n, int[] arr){

        for(int i = 0; i < n-1; i++){
            int curr = arr[i];
            int idx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < curr){
                    curr = arr[j];
                    idx = j;
                }
            }
            if(idx != i){
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }
        return arr;
    }
}

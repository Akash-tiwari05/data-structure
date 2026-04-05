package sorting.techneques;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }*/

        int[] arr = {6,2,4,1,9};

        int[] ans = bubbleSort(5, arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] bubbleSort(int n, int[] arr){

        for(int i = 0; i < n; i++){

            boolean swapped = false;

            for(int j = 0; i < (n - i - 1) ; j++){
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

            }

            if(!swapped) {
                break;
            }
        }
        return arr;
    }
}

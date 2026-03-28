package sorting.introduction;

import java.util.Arrays;

public class NobleElements {

    public static void main(String[] args) {
        int[] arr = {3,2,1,3};
        //System.out.println(nobleElement(arr));
        System.out.println(nobleElement2(arr));
    }

    //brute force method
    public static int nobleElement(int[] arr){
        int n= arr.length;
        int p = -1;
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] > ele){
                    count++;
                }
            }
            if(count == ele){
                p = Math.max(ele,p);
            }
        }
        return p;
    }

    //naive solution using sorting algo tc - O(nlogn)
    public static int nobleElement2(int[] arr){
        int n= arr.length;
        int p = -1;
        Arrays.sort(arr);
        int i = 0;
        while(i < n){
            while (i < n-1 && arr[i] == arr[i+1]) i++;

            int idx = (n - i - 1);
            if(idx == arr[i]){
                p = Math.max(p, arr[i]);
            }
            i++;
        }
        return p;
    }
}

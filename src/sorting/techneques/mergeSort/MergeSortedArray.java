package sorting.techneques.mergeSort;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,nums2.length);
        merge(nums1,3,nums2,nums2.length);
    }

    //naive solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] num = new int[m];
        for(int k = 0; k < m; k++){
            num[k] = nums1[k];
        }

        int k = 0;
        while(i < m && j < n){

            if(num[i] <= nums2[j]){
                nums1[k] = num[i];
                i++;
            }else{
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (j < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }

        while (i < m){
            nums1[k] = num[i];
            i++;
            k++;
        }

        System.out.println(Arrays.toString(nums1));
    }

    //optimal solution without extra space
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int k = m + n -1;
        while(i >= 0 && j >= 0){

            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }


        System.out.println(Arrays.toString(nums1));
    }

}

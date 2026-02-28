package binarySearch.search;

public class CeilInASortedArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 8, 10, 11, 12, 19}, x = 5;
        System.out.println(findCeil(arr,x));
    }

    public static int findCeil(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length -1;
        int ansIdx = -1;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(arr[mid] >= x){
                ansIdx = mid;
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return ansIdx;
    }
}

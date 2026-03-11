package binarySearch.search;

public class MinimumDiffElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,3,8,10,15};
        int key = 12; //output 10
        System.out.println(getMin(arr,key));
    }

    public static int getMin(int[] arr, int key){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = low+(high- low)/2;
            if(arr[mid] == key){
                return arr[mid];
            } else if (arr[mid] < key) {
                low = mid+1;
            }else{
                high = mid -1;
            }
        }

        if(low >= arr.length) return arr[high];
        if(high < 0) return arr[low];

        if(Math.abs(arr[low]-key) < Math.abs(arr[high]-key)){
            return arr[low];
        }

        return arr[high];
    }
}

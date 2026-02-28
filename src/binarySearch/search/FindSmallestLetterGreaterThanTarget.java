package binarySearch.search;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {

        char[] arr = {'x','x','y','y'};
        char target = 'z';
        System.out.println(nextGreatestLetter(arr,target));
    }

    public static char nextGreatestLetter(char[] arr, char target) {

        int low= 0;
        int high = arr.length -1;

        if(arr[high] <= target) return arr[low];
        while (low <= high){
            int mid = low + (high- low)/2;

            if(arr[mid] <= target){
                low = mid+1;
            }
            else {
                high = mid -1;
            }
        }
        return arr[low];
    }
}

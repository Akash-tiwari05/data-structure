package binarySearch.bitonicArraySearch;

public class FindInMountainArray {

    public static void main(String[] args) {
        int[] arr= {0,5, 2};
        System.out.println(findInMountainArray(2,arr));
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
        int low = 0;
        int high = mountainArr.length-1;
        while (low < high){
            int mid = low + (high-low)/2;
            if(mountainArr[mid] < mountainArr[mid+1]){
                low= mid+1;
            }else{
                high= mid;
            }
        }

        int peak = low;

        int leftSortedArr = leftSorted(target,mountainArr,0,peak-1);
        if(leftSortedArr != -1){
            return leftSortedArr;
        }
        int rightSortedArr = rightSorted(target,mountainArr,peak,mountainArr.length -1);

        if(rightSortedArr != -1) {
            return rightSortedArr;
        }

        return -1;
    }

    public static int leftSorted(int target ,int[] mountainArr,
                                 int low,int high){
        while (low <= high){
            int mid = low+(high-low)/2;
            if(mountainArr[mid] == target){
                return mid;
            }else if (mountainArr[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
    //decreasing order
    public static int rightSorted(int target ,int[] mountainArr,
                                 int low,int high){
        while (low <= high){
            int mid = low+(high-low)/2;
            if(mountainArr[mid] == target){
                return mid;
            }else if (target < mountainArr[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}

/*
interface MountainArray {
    public int get(int index) {}
    public int length() {}
}*/

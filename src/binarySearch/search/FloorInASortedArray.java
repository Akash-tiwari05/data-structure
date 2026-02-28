package binarySearch.search;

public class FloorInASortedArray {

    public static void main(String[] args) {

        int[] arr = {4, 15, 17, 17, 19, 20, 21, 22, 22, 25, 26, 26, 26, 28,
                28,28,31, 31,32,33,34,34,35,36,36,37,38,38,39,41,41,42,43,43,44
                ,44,45,45,46,47,49,49,50,75,94};
        int x = 26;

        //Largest number less than or equal to 5 is 2, whose index is 1.
        System.out.println(findFloor(arr,x));
    }

    public static int findFloor(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length -1;
        int ansIdx = -1;
        while(start <= end){
            int mid = start +(end - start)/2;

            if(arr[mid] <=x){
                ansIdx = Math.max(ansIdx,mid);
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        return ansIdx;
    }
}

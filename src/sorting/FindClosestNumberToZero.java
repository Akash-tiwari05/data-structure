package sorting;

public class FindClosestNumberToZero {

    public static void main(String[] args) {
        int[] arr ={-4,-2,1,4,8};
        System.out.println(findClosestNumber(arr));
    }

    public static int findClosestNumber(int[] arr) {
        int minValue =  Math.abs(arr[0]);
        int closest= arr[0];
        for(int i = 1; i < arr.length; i++){
            if(minValue >  Math.abs(arr[i])){
                minValue = Math.abs(arr[i]);
                closest = arr[i];
            }
            if(minValue ==  Math.abs(arr[i])){
                if(closest <= arr[i]){
                    closest = arr[i];
                }
            }
        }
        return closest;
    }
}

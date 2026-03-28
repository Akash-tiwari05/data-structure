package prefixsum;

public class LuckyNumber {

    public static void main(String[] args) {
        int[] arr = {5,4,7,8,4,8,8,3,7,7,6,3,7
                ,6,5,6,8,4,5,7,4,7,7,5,2,5,6,6,8,1,6,8,8,8,9,3,2,9};

        System.out.println(findLucky(arr));
        System.out.println(findLucky2(arr));
    }

    public static int findLucky(int[] arr) {
        int[] ans = new int[501];
        for(final int ele: arr){
            ans[ele]++;
        }

        int lucky = -1;
        for(int i = 0; i < arr.length; i++){
            if(ans[arr[i]] == arr[i]){
                lucky = Math.max(lucky,arr[i]);
            }
        }

        return lucky;
    }

    public static int findLucky2(int[] arr) {
        int[] ans = new int[501];
        for(final int ele: arr){
            ans[ele]++;
        }

        int lucky = 0;
        for(int i = 500; i >= 1; i--){
            if(ans[i] == i){
                lucky = i;
                return lucky;
            }
        }

        return -1;
    }

}

package bitsManupulation;

public class SingleNumberII {

    public static void main(String[] args) {

        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int setBits = 0;
            for (int num: nums){
                setBits += (num >> i) & 1;
            }
            setBits %= 3;
            ans |= setBits <<i;
        }
        return ans;
    }
}

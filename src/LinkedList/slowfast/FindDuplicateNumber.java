package LinkedList.slowfast;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];
        // slow fast to find the loop/ cycle in our array
        //use Floyd’s cycle algorithm
        //0 -> 1 ->3 -> 2 -><- 4
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        int temp = nums[0];
        while (slow != temp){
            slow = nums[slow];
            temp = nums[temp];
        }
        return temp;
    }
}

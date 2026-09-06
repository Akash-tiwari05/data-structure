package twoPointers;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int n = height.length;
        int[] leftMax = new int[n];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        int[] rightMax = new int[n];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }

        int trapping = 0;

        for (int i = 0; i < n; i++) {

            int minHeight = Math.min(leftMax[i],rightMax[i]);
            int storeWater = minHeight - height[i];
            if(storeWater> 0){
                trapping += storeWater;
            }
        }
        return trapping;
    }
}

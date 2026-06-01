package greedy;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public static void main(String[] args) {

        int[] cost = {6,5,7,9,2,2};
        System.out.println(minimumCost(cost));
    }

    public static int minimumCost(int[] cost) {

        int n = cost.length;
        int minCost = 0;
        for(int price : cost){
            minCost += price;
        }

        if(n <= 2) return minCost;

        Arrays.sort(cost);
        for (int i = n-3; i >= 0 ; i -= 3) {
            minCost -= cost[i];

        }
        return minCost;
    }

}

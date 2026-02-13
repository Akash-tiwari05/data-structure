package greedy;

import java.util.Arrays;
import java.util.HashMap;

public class FractionalKnapsack {

    public static void main(String[] args) {

        int[] value = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;
        System.out.println(fractionalKnapsack(value,wt, capacity));
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = wt.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i],wt[i]);
        }

        Arrays.sort(items, (a,b) -> Double.compare(b.ratio,a.ratio));

        double maxCapacity = 0.0;
        for (int i = 0; i < n; i++) {
            if(capacity >= items[i].wt){
                maxCapacity += items[i].value;
                capacity -= items[i].wt;
            }
            else{
                maxCapacity += items[i].ratio*capacity;
                break;
            }
        }
        return Math.round(maxCapacity * 1_000_000.0) / 1_000_000.0;

    }


}

class Item{
    int value;
    int wt;
    double ratio;

    Item(int value,int wt){
        this.value = value;
        this.wt = wt;
        this.ratio = (double) value/wt;
    }
}

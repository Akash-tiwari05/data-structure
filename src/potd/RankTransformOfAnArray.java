package potd;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {

    public static void main(String[] args) {

        int[] arr = {37,12,28,9,100,56,80,5,12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));

    }

    public static int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        if(n == 0) return new int[]{};

        int[] temp = arr.clone();
        HashMap<Integer,Integer> map = new HashMap<>();

        Arrays.sort(temp);
        int rank = 1;
        for (int ele : temp){
            if(!map.containsKey(ele)){
                map.put(ele,rank++);
            }
        }

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            arr[i] = map.get(key);

        }

        return arr;
    }
}

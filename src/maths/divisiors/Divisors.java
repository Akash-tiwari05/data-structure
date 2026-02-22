package maths.divisiors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Divisors {

    public static void main(String[] args) {

        System.out.println("Brute force = "+ Arrays.toString(divisors1(24)));

        System.out.println("-".repeat(50));

        System.out.println("Optimal solution = "+ Arrays.toString(divisors2(84)));
    }

    //brute force
    public static int[] divisors1(int n){
        List<Integer> ans = new ArrayList<>();
        //exam 24 = {1,2,3,4,6,8,12,24}
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                ans.add(i);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;
        for(int ele: ans){
            result[i] = ele;
            i++;
        }
        return result;
    }

    //Optimized solution
    public static int[] divisors2(int n){
        List<Integer> ans = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        //observation
        /*
        {(1,24),(2,12),(3,8),(4,6)}
         */
        for (int i = 1; i*i <= n; i++) {
            if(n % i == 0){
                ans.add(i);
                if(i != n/i){
                    large.add(n/i);
                }
            }
        }
        Collections.reverse(large);
        ans.addAll(large);
        //solution
        int[] result = new int[ans.size()];
        int i = 0;
        for(int ele: ans){
            result[i] = ele;
            i++;
        }
        return result;
    }
}

package maths.modulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//find the m (m > 1)? A and B is given [a - b] > 1 such that a % m == b % m
public class RemainderEquals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findNumber2(a, b));
        System.out.println(findNumber(a, b));
        System.out.println(findNumber3(a, b));
    }

    //m1
    public static int findNumber(int a, int b){

        for (int i = 2; i < Math.max(a, b); i++) {
            if((a % i) == (b % i)) return i;
        }

        return -1;
    }

    //m2
    public static List<Integer> findNumber2(int a, int b){

        List<Integer> list = new ArrayList<>();
        int diff =  Math.abs(a-b);
        for (int i = 2; i <= diff; i++) {
            if(diff % i == 0){
                list.add(i);
            }
        }
        return list;
    }

    //m3
    public static List<Integer> findNumber3(int a, int b){

        List<Integer> list = new ArrayList<>();

        int diff =  Math.abs(a-b);

        if(diff <= 1) return list;

        for (int i = 2; i*i <= diff; i++) {
            if(diff % i == 0){
                list.add(i);

                if(i != diff / i){
                    list.add(diff/i);
                }
            }
        }
        if (!list.contains(diff)) {
            list.add(diff);
        }
        Collections.sort(list);
        return list;
    }
}

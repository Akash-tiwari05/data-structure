package maths.divisiors;

import java.util.Scanner;

public class IsPrime {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(isPrime(num));
    }

    public static boolean isPrime(int num){

        if(num < 2) return false;
        if (num == 2) return true;

        if(num %2 == 0) return false;

        for (int i = 3; i*i < num; i += 2) {
            if(num % i == 0) return false;
        }

        return true;
    }

}

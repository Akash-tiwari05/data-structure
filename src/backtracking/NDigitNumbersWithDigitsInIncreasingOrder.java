package backtracking;

import java.util.ArrayList;

public class NDigitNumbersWithDigitsInIncreasingOrder {

    public static void main(String[] args) {

        System.out.println(increasingNumbers(2));
    }

    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here

        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 1){
            for (int i = 0; i < 10; i++) {
                ans.add(i);
            }
            return ans;
        }
        helper(n,ans,0);
        return ans;
    }
    private static void helper(int n, ArrayList<Integer> list, int num) {

        if(n == 0){
            list.add(num);
            return;
        }

        int lastDigit = num % 10;

        for (int i = 1; i <= 9; i++) {

            if( num == 0 || i > lastDigit){

                num = num*10 + i;

                helper(n-1,list,num);

                num /= 10;
            }


        }

    }
}

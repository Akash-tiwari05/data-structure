package LinkedList.slowfast;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(happyNumber(2));
    }

    public static boolean happyNumber(int n) {
        // code here
        if (n <= 0) return false;
        int slow = n;
        int fast = n;
        while (fast != 1){
            slow = squareOfDigitSum(slow);
            fast = squareOfDigitSum(squareOfDigitSum(fast));

            if(slow == fast && slow != 1) return false;
        }

        return true;
    }

    public static int squareOfDigitSum(int n){
        int sum= 0;
        while(n != 0){
            int d = n % 10;
            n /= 10;
            sum += d*d;
        }
        return sum;
    }
}

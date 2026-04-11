package recursion;

public class CountDigit {


    public static void main(String[] args) {
        System.out.println(countDigits(10));
    }

    public static int countDigits(int n) {
        if(n < 10){
            return 1;
        }

        return 1 + countDigits(n / 10);
    }
}

package potd;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public static void main(String[] args) {

        int n = 10203004;
        System.out.println(sumAndMultiply(n));
    }

    public static long sumAndMultiply(int n) {

        if (n == 0)
            return 0;

        long nonZero = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0)
                nonZero = nonZero * 10 + digit;
            n /= 10;
        }

        long number = reverse(nonZero);

        int sum = 0;
        long temp = number;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return number * sum;
    }

    private static long reverse(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}

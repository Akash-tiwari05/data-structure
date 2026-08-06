package potd;

public class SmallestDivisibleDigitProductI {

    public static void main(String[] args) {

        System.out.println(smallestNumber(10, 2));
    }

    public static int smallestNumber(int n, int t) {

        for (int i = n; i <= 100 ; i++) {

            int product = digitProducts(i);
            if(product % t == 0) return i;
        }

        return -1;
    }

    public static int digitProducts(int num){

        int ans = 1;
        while (num > 0){
            ans *= num% 10;
            num /= 10;
        }
        return ans;
    }
}


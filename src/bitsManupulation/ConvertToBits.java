package bitsManupulation;


//converts bits from number
public class ConvertToBits {

    public static void main(String[] args) {
        System.out.println(convertBits(11));
        System.out.println("Minimum number of bits required o store above number: "
                +convertBits(11).length());

    }

    public static String convertBits(int n){

        if(n == 0) return "0";

        boolean isNegative = n <0;
        n = Math.abs(n);
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            sb.append(n%2);
            n /= 2;
        }
        if (isNegative){
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}

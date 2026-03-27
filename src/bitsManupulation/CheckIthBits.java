package bitsManupulation;

//check ith bit set or not
public class CheckIthBits {

    public static void main(String[] args) {
        System.out.println(isSetBit(18,2));
        System.out.println(isSetBit2(18,1));


    }

    public static boolean isSetBit(int n, int i){
        /*n = n >> i;
        return (n & 1) == 1;*/
        return (n & (1 << i)) != 0;
    }
    public static boolean isSetBit2(int n, int i){
        return ((n & (1 << i)) == (1 << i));
    }
}

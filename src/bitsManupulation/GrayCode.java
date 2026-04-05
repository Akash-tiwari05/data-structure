package bitsManupulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {

        System.out.println(graycode(2));
    }

    public static ArrayList<String> graycode(int n) {
        // code here

        ArrayList<String> result = new ArrayList<>();

        int total = 1 << n; // 2^n

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);

            // Convert to n-bit binary string
            String binary = String.format("%" + n + "s", Integer.toBinaryString(gray))
                    .replace(' ', '0');

            result.add(binary);
        }

        return result;
    }
}

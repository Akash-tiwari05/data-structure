package dynamicPrograming.matrixChain;

import java.util.HashMap;

public class ScrambledString {

    public static void main(String[] args) {

        String s1 = "great", s2 = "rgeat";
        System.out.println(isScramble(s1,s2));
    }
    static boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) return false;
        if(s1.isEmpty()) return true;
        HashMap<String, Boolean> map = new HashMap<>();
        return solve(s1, s2,map);
    }

    public static boolean solve(String s1, String s2, HashMap<String,Boolean> map) {

        // Memoization key
        String key = s1 + " " + s2;

        if(map.containsKey(key)){
            return map.get(key);
        }

        // If equal
        if (s1.equals(s2)){
            map.put(key,true);
            return true;
        }

        // Length <= 1 and not equal
        if (s1.length() <= 1) {
            map.put(key,false);
            return false;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            boolean cond1 =
                    solve(s1.substring(0, i), s2.substring(0, i),map) &&
                            solve(s1.substring(i), s2.substring(i),map);

            // Case 2: Swap
            boolean cond2 =
                    solve(s1.substring(0, i), s2.substring(n - i),map) &&
                            solve(s1.substring(i), s2.substring(0, n - i),map);

            if (cond1 || cond2) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key,false);
        return false;
    }

    //recursion
    public static boolean solve2(String s1, String s2) {

        // If equal
        if (s1.equals(s2)) return true;

        // Length <= 1 and not equal
        if (s1.length() <= 1) return false;

        int n = s1.length();

        boolean flag = false;

        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            boolean cond1 =
                    solve2(s1.substring(0, i), s2.substring(0, i)) &&
                            solve2(s1.substring(i), s2.substring(i));

            // Case 2: Swap
            boolean cond2 =
                    solve2(s1.substring(0, i), s2.substring(n - i)) &&
                            solve2(s1.substring(i), s2.substring(0, n - i));

            if (cond1 || cond2) {
                flag = true;
                break;
            }
        }

        return flag;
    }

}

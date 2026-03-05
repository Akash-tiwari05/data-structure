package string.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s,t));
        System.out.println(isIsomorphic2("Using two pass"+s,t));
    }

    //using hashmap
    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(sMap.containsKey(c1)){
                if(sMap.get(c1) != c2) return false;
            }else{
                sMap.put(c1, c2);
            }

            if(tMap.containsKey(c2)){
                if(tMap.get(c2) != c1) return false;
            }else{
                tMap.put(c2, c1);
            }

        }
        return true;
    }

    //using two pass approach
    public static boolean isIsomorphic2(String s, String t) {

        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sMap[c1] != tMap[c2]) return false;
            // Store position +1 (0 means unseen)
            sMap[c1] = i + 1;
            tMap[c2] = i + 1;

        }
        return true;
    }
}

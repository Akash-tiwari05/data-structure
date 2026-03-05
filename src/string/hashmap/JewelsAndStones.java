package string.hashmap;

import java.util.HashMap;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
    }
    //using hashmap
    public static int numJewelsInStones(String jewels, String stones) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: stones.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int countJewels = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            if(map.containsKey(ch)){
                countJewels += map.get(ch);
            }
        }
        return countJewels;
    }

    //using tho pass methods
    public static int numJewelsInStones2(String jewels, String stones) {

        int[] arr = new int[60];
        for(char c: stones.toCharArray()){
            arr[c-'A']++;
        }

        int countJewels = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            countJewels+= arr[ch-'A'];
        }
        return countJewels;
    }
}

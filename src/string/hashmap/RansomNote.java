package string.hashmap;

import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote,magazine));
        System.out.println(canConstruct2(ransomNote,magazine));
    }

    //using hashmap
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapRan = new HashMap<>();
        for (char c: ransomNote.toCharArray()){
            mapRan.put(c, mapRan.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> mapMag = new HashMap<>();
        for (char c: magazine.toCharArray()){
            mapMag.put(c, mapMag.getOrDefault(c,0)+1);
        }

        for (char key : mapRan.keySet()){
            if(!mapMag.containsKey(key)) return false;
            if(mapRan.get(key) > mapMag.get(key)) return false;
        }
        return true;
    }

    //using array two pass method
    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] magFreq = new int[26];
        for (char c: magazine.toCharArray()){
            magFreq[c-'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            magFreq[ch-'a']--;
            if(magFreq[ch-'a'] == -1){
                return false;
            }
        }

        return true;
    }
}

package string.hashmap;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //output = [["bat"],["nat","tan"],["ate","eat","tea"]]
        //System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams2(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sorted = sort(s);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        for (String key: map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }

    private static String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String sorted = new String(c);
        return sorted;
    }

    private static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int[] freqS = new int[26];
        for (char c : s.toCharArray()){
            freqS[c-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqS[ch-'a']--;
            if(freqS[ch-'a'] == -1){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> groupAnagrams2 (String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c: s.toCharArray()){
                freq[c-'a']++;
            }

            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

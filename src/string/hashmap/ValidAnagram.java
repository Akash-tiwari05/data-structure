package string.hashmap;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {

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
}

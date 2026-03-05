package string.hashmap;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {

        String s = "aaa";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {

        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch -'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(freq[ch-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

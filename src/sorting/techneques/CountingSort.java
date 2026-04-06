package sorting.techneques;

public class CountingSort {

    public static void main(String[] args) {

        System.out.println(countSort("geeksforgeeks"));
    }

    public static String countSort(String s) {
        // code here

        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while(freq[i] != 0){
                int ascii = i + 'a';
                char ch = (char) ascii;
                sb.append(ch);
                freq[i]--;
            }
        }

        return sb.toString();
    }
}

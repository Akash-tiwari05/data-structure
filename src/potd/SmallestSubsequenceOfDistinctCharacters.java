package potd;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            // Skip if already included
            if (visited[c - 'a']) {
                continue;
            }

            // Maintain increasing lexicographical order
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("dog");
        System.out.println(wordBreak(s,wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        helper(0,s,new StringBuilder(),list,set);
        Collections.reverse(list);
        return list;
    }

    private static void helper(int index, String s, StringBuilder sb,
                               List<String> list, HashSet<String> set){

        if(index == s.length()){
            list.add(sb.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i+1);
            int len = sb.length();
            if(set.contains(temp)){
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(temp);
                helper(i+1,s,sb,list,set);
                sb.setLength(len);
            }

        }
    }
}

package recursion;

public class ReverseString {

    public static void main(String[] args) {
        String s = "harshit";
        int n = s.length();
        StringBuilder rev = new StringBuilder();
        System.out.println(reverse(s,rev,n-1));
        System.out.println(reverse(s));
    }

    public static String reverse(String s, StringBuilder rev, int n){

        if(n < 0){
            return rev.toString();
        }
        return reverse(s,rev.append(s.charAt(n)), n-1);
    }

    public static String reverse(String s){

        if(s.isEmpty()){
            return "";
        }
        return s.charAt(s.length()-1)+reverse(s.substring(0,s.length()-1));
    }
}

package string.toPointer;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {

        String s = "IceCreAm";
        System.out.println(reverseVowels(s));// AceCreIm
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() -1;
        while (left < right){
            while (left < right && !isVowels(arr[left])){
                left++;
            }
            while (left < right && !isVowels(arr[right])){
                right--;
            }

            if(isVowels(arr[left]) && isVowels(arr[right])){
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            left++;
            right--;
        }
        return new String(arr);
    }
    private static boolean isVowels(char c){
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}

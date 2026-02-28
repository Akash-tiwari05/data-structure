package binarySearch.search;

public class NextLetter {

    public static void main(String[] args) {

        char[] ch = {'b','c','f','h'};
        char target = 'h';
        System.out.println(nextGreatestLetter(ch,target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length-1;
        char ans = letters[0];

        while (low <= high){
            int mid = low + (high - low)/2;

            if(letters[mid] > target){
                ans = letters[mid];
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}

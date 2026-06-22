package potd;

public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {

        int[] alp = new int[26];

        for(char ch : text.toCharArray()){
            alp[ch - 'a']++;
        }

        /*int minBallons = 10000;
        for (int i = 0; i < 26; i++) {
            if(i == 0 || i == 1 || i == 11 || i == 13 || i == 14){

                if(i == 11 || i == 14){
                    minBallons = Math.min(minBallons, alp[i]/2);
                }else{
                    minBallons = Math.min(minBallons, alp[i]);
                }

            }
        }
        return minBallons;*/

        return Math.min(
          Math.min(Math.min(alp[0],alp['b'-'a']),alp['n'-'a']),
                Math.min(alp['l'-'a']/2, alp['o' - 'a']/2)
        );
    }

}

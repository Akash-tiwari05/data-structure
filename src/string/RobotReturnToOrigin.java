package string;

import java.util.HashMap;

public class RobotReturnToOrigin {
    public static void main(String[] args) {

        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle2("UD"));
    }

    public static boolean judgeCircle(String moves) {

        if(moves.length() % 2 != 0) return false;

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('U',0);
        map.put('D',0);
        map.put('R',0);
        map.put('L',0);
        for (char key: moves.toCharArray()){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        if(map.get('U') - map.get('D') != 0){
            return false;
        }
        if(map.get('R') - map.get('L') != 0) return false;
        return true;
    }

    public static boolean judgeCircle2(String moves) {
        if(moves.length() % 2 != 0) return false;

        int right = 0;
        int up = 0;

        for(char c: moves.toCharArray()){
            switch (c){
                case 'U' -> up++;
                case 'D' -> up--;
                case 'L' -> right--;
                default -> right++;
            }
        }
        return right == 0 && up == 0;
    }

}

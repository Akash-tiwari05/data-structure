package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(4,0,0,0));
    }

    public static int towerOfHanoi(int n, int from, int to, int aux) {
        // code here

        if(n == 1){
            return 1;
        }

        int left = towerOfHanoi(n-1,from,aux,to);
        int right = towerOfHanoi(n-1,aux,to,from);

        return left+right+1;
    }
}

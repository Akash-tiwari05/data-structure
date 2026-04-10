package recursion;

public class Print {

    public static void main(String[] args) {
        printOrder(5);
        System.out.println();
        printReverse(5);
    }

    //print 1 - n
    public static void printOrder(int n){

        if(n == 0) return;
        printOrder(n - 1);
        System.out.print(n+", ");
    }

    //print 1 - n
    public static void printReverse(int n){

        if(n == 0) return;
        System.out.print(n+", ");
        printReverse(n - 1);

    }
}

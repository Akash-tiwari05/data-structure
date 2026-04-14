package recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println(st);
        // k is the middleElement
        int k = (st.size()/2)+1;
        deleteMid(st,k);
        System.out.println(st);
    }

    public static void deleteMid(Stack<Integer> st, int k) {
        // code here

        if(k == 1){
            st.pop();
            return;
        }

        //if(st.isEmpty()) return;

        int top = st.pop();
        deleteMid(st,k-1);
        st.push(top);
    }
}

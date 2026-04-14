package recursion;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);
    }

    public static void reverseStack(Stack<Integer> st){

        if(st.isEmpty()){
            return;

        }

        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
        //st.push(top);
    }

    public static void insertAtBottom(Stack<Integer> st, int ele){

        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,ele);
        st.push(top);
    }
}

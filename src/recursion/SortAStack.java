package recursion;

import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(4);
        st.push(3);
        st.push(5);
        st.push(2);
        //System.out.println(st);
        sortStack(st);
        System.out.println(st);
    }


    public static void sortStack(Stack<Integer> st){

        if(st.isEmpty()){
            return;
        }

        int last = st.pop();

        sortStack(st);
        insert(st,last);
    }

    public static void insert(Stack<Integer> st, int ele){

        if(st.isEmpty() || st.peek() <= ele){
            st.push(ele);
            return;
        }

        int temp = st.pop();
        insert(st, ele);
        st.push(temp);
    }

}

package Stk;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * 
 */
public class Sortstk {

    static void sortedInsert(Stack<Integer> st, int key) {
        if (st.isEmpty() || key > st.peek()) {
            st.push(key);
            return;
        }
        int top=st.pop();
        sortedInsert(st, key);
        st.push(top);
    }

    static void sort(Stack<Integer> st) {
        if (st == null || st.isEmpty()) {
            return;
        }
        int top = st.pop();
        sort(st);
        sortedInsert(st, top);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 30, 10, 1);
        Stack<Integer> s = new Stack<>();
        s.addAll(list);
        s.stream().forEach(System.out::print);
        System.out.println();
        sort(s);
        s.stream().forEach(System.out::print);
    }
}

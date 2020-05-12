package leetcode.lc01000.lc0200;

import java.util.ArrayList;
import java.util.List;

public class Lc0155 {
}
class MinStack {
    List<Integer> list = new ArrayList();
    List<Integer> minStack = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        if (minStack.size() == 0){
            minStack.add(x);
            return;
        }
        if (minStack.get(minStack.size() - 1) > x){
            minStack.add(x);
        }else{
            minStack.add(minStack.get(minStack.size() - 1));
        }
    }

    public void pop() {
        list.remove(list.size() - 1);
        minStack.remove(minStack.size() -1);
    }

    public int top() {
        return list.get(list.size() -1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
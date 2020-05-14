package leetcode.lc01000.lc0100;

public class Lc0023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1 ){
            return null;
        }
        ListNode newHead = null;
        ListNode currentNode = null;
        int minIndex = -1;
        while (true){
            minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null){
                    continue;
                }
                if (minIndex == -1){
                    minIndex = i;
                }
                if (lists[i].val <= lists[minIndex].val){
                    minIndex = i;
                }
            }
            if (minIndex == -1){
                break;
            }
            if (newHead == null){
                newHead = lists[minIndex];
                currentNode = lists[minIndex];
            }else {
                currentNode.next = lists[minIndex];
                currentNode = lists[minIndex];
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }

    public static void main(String[] args) {

    }
}

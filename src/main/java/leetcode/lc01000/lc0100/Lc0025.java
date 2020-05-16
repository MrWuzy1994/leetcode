package leetcode.lc01000.lc0100;


import java.util.Stack;

public class Lc0025 {
     ListNode newHead =  new ListNode(0);
     Stack<ListNode> stack = new Stack<>();
    public  ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;
        ListNode currentNode = head;
        ListNode newHeadCurrent = newHead;
        while (true){
            for (int i = 0; i < k && currentNode != null; i++) {
                stack.push(currentNode);
                currentNode = currentNode.next;
            }
            if (stack.size() < k){
                newHeadCurrent.next = head;
                break;
            }
            for (int i = 0; i < k; i++) {
                newHeadCurrent.next = stack.pop();
                newHeadCurrent = newHeadCurrent.next;
            }
            head = currentNode ;
        }
        return newHead.next;
    }


   class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

      @Override
      public String toString() {
          return super.toString();
      }
  }


}

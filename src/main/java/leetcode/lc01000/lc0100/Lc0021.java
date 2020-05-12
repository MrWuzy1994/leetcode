package leetcode.lc01000.lc0100;

public class Lc0021 {
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution0027 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsP(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = null;
        ListNode current = null;
        if (l1.val > l2.val){
            head = l2;
            current = l2;
            l2 = l2.next;
        }else{
            head = l1;
            current = l1;
            l1 = l1.next;
        }
        while ( l1 != null && l2 != null){
            if (l1.val > l2.val){
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }

        while (l1 != null){
            current.next = l1;
            current = l1;
            l1 = l1.next;
        }
        while (l2 != null){
            current.next = l2;
            current = l2;
            l2 = l2.next;
        }
        return head;

    }
}

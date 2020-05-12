package leetcode.lc01000.lc0100;

public class Lc0083 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        delete(head);
        return head;
    }

    /**
     * 删除重复节点
     * @param node
     */
    public void delete(ListNode node){
        //如果为空,或者没有下一个节点,返回
        if (node == null || node.next == null){
            return;
        }
        //判断当前节点和下一个节点的val是否相同
        if (node.val == node.next.val){//相同则使当前节点的下一个节点等于当前节点的下下个节点
            node.next = node.next.next;
            //更改当前节点的下一个节点以后,继续判断当前节点
            delete(node);
        }else{//不相同,判断当前节点的下一个节点
            delete(node.next);
        }
    }
}




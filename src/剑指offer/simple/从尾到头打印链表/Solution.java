package 剑指offer.simple.从尾到头打印链表;

public class Solution {

//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        ListNode null_head = new ListNode(0), p = head;
        int len = 0, idx = 0;
        while(p != null){
            ListNode q = p;
            p = p.next;
            q.next = null_head.next;
            null_head.next = q;
            len++;
        }
        p = null_head.next;
        int[] re = new int[len];
        while(p != null) {
            re[idx++] = p.val;
            p = p.next;
        }
        return re;
    }

}

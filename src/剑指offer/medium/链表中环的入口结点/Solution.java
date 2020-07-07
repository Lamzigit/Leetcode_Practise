package 剑指offer.medium.链表中环的入口结点;

/*

*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)return null;
        ListNode faster = pHead.next, slower = pHead;
        if(faster == null) return null;
        faster = pHead.next;
        while(faster != slower)
        {
            slower = slower.next;
            faster = faster.next;
            if(faster == null || slower == null) return null;
            faster = faster.next;
        }
        int len = 1;
        for(;slower.next != faster;len++,slower = slower.next);
        for(faster = pHead;len>0;faster=faster.next,len--);
        for(slower = pHead;slower != faster;faster=faster.next, slower=slower.next);
        return faster;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
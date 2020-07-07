package 剑指offer.medium.两个链表的第一个公共结点;

/*

*/

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0, st = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        for(;p1 != null;len1++,p1 = p1.next);
        for(;p2 != null;len2++,p2 = p2.next);
        p1 = pHead1;
        p2 = pHead2;
        if((st = len1 - len2) < 0){
            p1 = pHead2;
            p2 = pHead1;
            st *= -1;
        }
        for(;st>0;st--,p1 = p1.next);
        for(;p1!=p2;p1 = p1.next,p2 = p2.next);
        return p2;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


//public class Solution {
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        int len1 = 0, len2 = 0, st = 0;
//        ListNode p1 = pHead1, p2 = pHead2;
//        for(;p1 != null;len1++,p1 = p1.next);
//        for(;p2 != null;len2++,p2 = p2.next);
//        if((st = len1 - len2) > 0){
//            p1 = pHead1;
//            p2 = pHead2;
//        } else {
//            p1 = pHead2;
//            p2 = pHead1;
//            st *= -1;
//        }
//        while(st>0)
//        {
//            st--;
//            p1 = p1.next;
//        }
//        while(p1 != p2)
//        {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p2;
//    }
//
//    class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//}

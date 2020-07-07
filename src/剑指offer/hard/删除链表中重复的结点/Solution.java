package 剑指offer.hard.删除链表中重复的结点;

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//public class Solution {
//    public ListNode deleteDuplication(ListNode pHead)
//    {
//        if(pHead == null || pHead.next == null) return pHead;
//        ListNode slower = pHead, faster = slower.next;
//
//        for(;slower != null && slower.next != null && slower.val == slower.next.val;slower = slower.next);
//        if(slower == null || slower.next == null) return null;
//        if(slower != pHead)
//        {
//            slower = slower.next;
//            pHead = slower;
//            faster = slower.next;
//        }
//
//        while(faster != null)
//        {
//            if(faster.next != null && faster.next.val == faster.val){
//                for(;faster != null && faster.next != null && faster.next.val == faster.val;faster=faster.next);
//                faster=faster.next;
//                slower.next = faster;
//            } else {
//                slower = slower.next;
//                faster=faster.next;
//            }
//        }
//
//        return pHead;
//    }
//
//    public class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//}


import java.util.HashMap;

public class Solution {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return pHead;
        HashMap<Integer, Integer> count = new HashMap<>();
        ListNode p = pHead;
        // 统计元素出现次数
        while(p != null)
        {
            if(!count.containsKey(p.val)){
                count.put(p.val, 1);
            } else {
                count.put(p.val, count.get(p.val)+1);
            }
            p = p.next;
        }
        // 定位链表起始点，因为有可能原来的起始点的元素就是相同元素，如 （1，1，1，1，1）或（1，1，2，2，3，3，4，4，5）
        ListNode faster = pHead;
        while(count.get(faster.val) > 1)
        {
            int flag = faster.val;
            for(;faster != null && faster.val == flag;faster = faster.next);
            if(faster == null) return null;
        }
        pHead = faster;
        // p指向已确定的非重复元素
        p = faster;
        // 确定起始点后，处理后续中段重复元素
        // faster指向最近的待检查元素
        faster = p.next;
        while(faster != null)
        {
            if(count.get(faster.val) > 1){
                int flag = faster.val;
                // 找到下一个待检查元素
                for(;faster != null && faster.val == flag;faster = faster.next);
                // 暂时将下一个待检查元素连接起来，等效于删除中段重复元素
                p.next = faster;
            } else {
                p = faster;
                faster = faster.next;
            }
        }
        /*
        后处理：
        若后端没有重复元素，则在循环里执行else代码块，使得faster成为p的后继，
        若faster不是p的后继，说明后端有重复元素延续至结尾，faster会等于null
        而跳出上面的循环，重复元素没有被截断，需要额外处理；
         */
        if(p.next != faster) p.next = null;
        return pHead;
    }

    public class ListNode {
        int val;
        Solution.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
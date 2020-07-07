package 剑指offer.medium.二叉搜索树与双向链表;


import java.util.ArrayList;
import java.util.Stack;


public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> treeArray = order(pRootOfTree);
        TreeNode p = treeArray.get(0), head = p;
        p.left = null;
        p.right = null;
        for (int i = 1; i < treeArray.size(); i++) {
            TreeNode tp = treeArray.get(i);
            tp.left = null;
            tp.right = null;
            p.left = tp;
            tp.right = p;
            p = tp;
        }
        return head;
    }

    public ArrayList<TreeNode> order(TreeNode pRootOfTree) {
        ArrayList<TreeNode> treeArray = new ArrayList<>();
        TreeNode p = pRootOfTree;
        Stack<TreeNode> treeStack = new Stack<TreeNode>();

        while (p != null || !treeStack.isEmpty()) {
            if (p != null) {
                treeStack.push(p);
                p = p.left;
            } else {
                p = treeStack.pop();
                treeArray.add(p);
                p = p.right;
            }
        }
        return treeArray;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
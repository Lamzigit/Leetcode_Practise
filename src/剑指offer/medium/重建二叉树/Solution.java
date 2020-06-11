package 剑指offer.medium.重建二叉树;

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        HashMap<Integer, Integer> in_map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            in_map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, in_map);
    }

    public TreeNode buildTree(
            int[] preorder,
            int[] inorder,
            int pre_start,
            int pre_end,
            int in_start,
            int in_end,
            HashMap<Integer, Integer> in_map
    ) {
        TreeNode root = new TreeNode(preorder[pre_start]);
        int i = in_map.get(preorder[pre_start]);
        int len_left = i - in_start, len_right = in_end - i;
        if(len_left > 0 ){
            int left_pre_start = pre_start + 1, left_pre_end = pre_start + len_left;
            int left_in_end = i-1;
            root.left = buildTree(preorder, inorder, left_pre_start, left_pre_end, in_start, left_in_end, in_map);
        } else {
            root.left = null;
        }

        if(len_right > 0 ){
            int right_pre_start = pre_start + len_left + 1, right_pre_end = pre_start + len_left + len_right;
            int right_in_start = i+1;
            root.right = buildTree(preorder, inorder, right_pre_start, right_pre_end, right_in_start, in_end, in_map);
        } else {
            root.right = null;
        }
        return root;
    }

    public static void main(String[] args) {
//        int[] pre = new int[]{3,9,20,15,7};
//        int[] in = new int[]{9,3,15,20,7};
        int[] pre = new int[]{1, 2};
        int[] in = new int[]{2, 1};
        Solution.TreeNode re = new Solution().buildTree(pre, in);
        System.out.println(re);
    }

}
































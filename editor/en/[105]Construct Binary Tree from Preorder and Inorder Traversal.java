//Given two integer arrays preorder and inorder where preorder is the preorder
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
// 
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
//
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 15572 
//👎 554


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return findNode(map, preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode findNode(HashMap<Integer, Integer> map, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart >= preEnd || inStart >= inEnd) return null;
            int rootVal = preorder[preStart];
            int rootIndex = map.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            int lenLeft = rootIndex - inStart;
            root.left = findNode(map, preorder, preStart + 1, lenLeft + preStart + 1, inorder, inStart, rootIndex);
            root.right = findNode(map, preorder, preStart + lenLeft + 1, preEnd, inorder, rootIndex + 1, inEnd);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
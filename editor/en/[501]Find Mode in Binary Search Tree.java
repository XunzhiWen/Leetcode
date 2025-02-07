//Given the root of a binary search tree (BST) with duplicates, return all the
//mode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal 
//to the node's key. 
// The right subtree of a node contains only nodes with keys greater than or 
//equal to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the 
//implicit stack space incurred due to recursion does not count).
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 3969
// 👎 798


package com.shuzijun.leetcode.editor.en;


import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a binary tree node.
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
        int count;
        int maxCount;
        List<Integer> res;
        TreeNode prev;

        public int[] findMode(TreeNode root) {
            count = 1;
            maxCount = 0;
            res = new ArrayList<>();
            prev = null;
            inOrder(root);
            return res.stream().mapToInt(i -> i).toArray();
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);

            if (prev == null || prev.val != root.val) {
                count = 1;
            } else count++;

            if (count > maxCount) {
                res.clear();
                res.add(root.val);
                maxCount = count;
            } else if (count == maxCount) {
                res.add(root.val);
            }
            prev = root;
            inOrder(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
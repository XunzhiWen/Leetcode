//Given the root of a binary tree, imagine yourself standing on the right side
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 12
//273 👎 1037


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> curr = new ArrayDeque<>();
            Queue<TreeNode> next = new ArrayDeque<>();
            next.offer(root);
            TreeNode node = null;
            while (!next.isEmpty()) {
                curr = next;
                next = new ArrayDeque<>();
                while (!curr.isEmpty()) {
                    node = curr.poll();
                    if (node.left != null) next.offer(node.left);
                    if (node.right != null) next.offer(node.right);
                }
                result.add(node.val);
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
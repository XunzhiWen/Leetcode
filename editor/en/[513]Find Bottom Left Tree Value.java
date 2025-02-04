//Given the root of a binary tree, return the leftmost value in the last row of
//the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [2,1,3]
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 38
//58 👎 298


package com.shuzijun.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode leftMost = queue.peek();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                if (queue.isEmpty()) return leftMost.val;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
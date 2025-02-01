//Given the root of a binary tree, return its maximum depth.
//
// A binary tree's maximum depth is the number of nodes along the longest path 
//from the root node down to the farthest leaf node. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 13
//281 👎 250


package com.shuzijun.leetcode.editor.en;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
//            BFS, 空间复杂度最好O（1）最差O（N）
/*            int maxDepth = 0;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                maxDepth++;
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.left != null) deque.add(node.left);
                    if (node.right != null) deque.add(node.right);
                }
            }
            return maxDepth;*/
//            DFS,空间复杂度O（H）
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
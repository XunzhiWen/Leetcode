/**
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the
 * two trees are overlapped while the others are not. You need to merge the two trees
 * into a new binary tree. The merge rule is that if two nodes overlap, then sum
 * node values up as the new value of the merged node. Otherwise, the NOT null node
 * will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in both trees is in the range [0, 2000].
 * -10⁴ <= Node.val <= 10⁴
 * <p>
 * <p>
 * Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 8885
 * 👎 308
 */

package com.shuzijun.leetcode.editor.en;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;

            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
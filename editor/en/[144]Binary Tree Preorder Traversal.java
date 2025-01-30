/**
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * <p>
 * <p>
 * Output: [1,2,3]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * <p>
 * <p>
 * Output: [1,2,4,5,6,7,3,8,9]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = []
 * <p>
 * <p>
 * Output: []
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: root = [1]
 * <p>
 * <p>
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Related Topics Stack Tree Depth-First Search Binary Tree 👍 8240 👎 215
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preOrder(root, res);
            return res;
        }

        private void preOrder(TreeNode node, List<Integer> res) {
            if (node == null) return;
            res.add(node.val);
            preOrder(node.left, res);
            preOrder(node.right, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
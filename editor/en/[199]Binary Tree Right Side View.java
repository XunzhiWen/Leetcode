/**
 * Given the root of a binary tree, imagine yourself standing on the right side of
 * it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * <p>
 * <p>
 * Output: [1,3,4]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,null,null,null,5]
 * <p>
 * <p>
 * Output: [1,3,4,5]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1,null,3]
 * <p>
 * <p>
 * Output: [1,3]
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: root = []
 * <p>
 * <p>
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 1245
 * 3 👎 1048
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> que = new ArrayDeque<>();
            que.add(root);
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = que.poll();
                    if (i == size - 1) res.add(node.val);
                    if (node.left != null) que.add(node.left);
                    if (node.right != null) que.add(node.right);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
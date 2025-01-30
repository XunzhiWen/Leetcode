/**
 * Given the root of a binary tree, return the bottom-up level order traversal of
 * its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics Tree Breadth-First Search Binary Tree 👍 4965 👎 326
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(temp);
            }
            return res.reversed();
/*
            List<List<Integer>> res = new ArrayList<>();
            BFS(root, 0, res);
            return res.reversed();
*/
        }

        private void BFS(TreeNode node, int depth, List<List<Integer>> res) {
            if (node == null) return;
            depth++;
            if (res.size() < depth) {
                List<Integer> temp = new ArrayList<>();
                res.add(temp);
            }
            res.get(depth - 1).add(node.val);
            BFS(node.left, depth, res);
            BFS(node.right, depth, res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
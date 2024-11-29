/**
 * <p>Given the <code>root</code> of a binary tree, determine if it is a <em>complete binary tree</em>.</p>
 *
 * <p>In a <strong><a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">complete binary tree</a></strong>, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2<sup>h</sup></code> nodes inclusive at the last level <code>h</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-1.png" style="width: 180px; height: 145px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,6]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/15/complete-binary-tree-2.png" style="width: 200px; height: 145px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,null,7]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The node with value 7 isn't as far left as possible.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li>
 * <li><code>1 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Breadth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 4341</li><li>👎 61</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
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
        public boolean isCompleteTree(TreeNode root) {
//            BFS
/*            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            Boolean nullNodeFound = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove(0);
                if (node == null) {
                    nullNodeFound = true;

                } else if (nullNodeFound) return false;
                else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            return true;*/

//            DFS
            return dfs(root, 0, countNodes(root));
        }

        private int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

        private boolean dfs(TreeNode node, int index, int n) {
            if (node == null) return true;
            if (index >= n) return false;
            return dfs(node.left, 2 * index + 1, n) && dfs(node.right, 2 * index + 2, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>A <strong>path</strong> in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence <strong>at most once</strong>. Note that the path does not need to pass through the root.</p>
 *
 * <p>The <strong>path sum</strong> of a path is the sum of the node's values in the path.</p>
 *
 * <p>Given the <code>root</code> of a binary tree, return <em>the maximum <strong>path sum</strong> of any <strong>non-empty</strong> path</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The optimal path is 2 -&gt; 1 -&gt; 3 with a path sum of 2 + 1 + 3 = 6.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" />
 * <pre>
 * <strong>Input:</strong> root = [-10,9,20,null,null,15,7]
 * <strong>Output:</strong> 42
 * <strong>Explanation:</strong> The optimal path is 15 -&gt; 20 -&gt; 7 with a path sum of 15 + 20 + 7 = 42.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 3 * 10<sup>4</sup>]</code>.</li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Dynamic Programming</li><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 17057</li><li>👎 750</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*//  Definition for a binary tree node.
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
    }*/

    class Solution {
        int maxSum;

        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            gainMax(root);
            return maxSum;
        }

        private int gainMax(TreeNode root) {
            if (root == null) return 0;
            int left = Math.max(0, gainMax(root.left));
            int right = Math.max(0, gainMax(root.right));
            maxSum = Math.max(maxSum, root.val + left + right);
            return Math.max(left, right) + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
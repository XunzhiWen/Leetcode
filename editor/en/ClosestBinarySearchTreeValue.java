/**
 * <p>Given the <code>root</code> of a binary search tree and a <code>target</code> value, return <em>the value in the BST that is closest to the</em> <code>target</code>. If there are multiple answers, print the smallest.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/12/closest1-1-tree.jpg" style="width: 292px; height: 302px;" />
 * <pre>
 * <strong>Input:</strong> root = [4,2,5,1,3], target = 3.714286
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1], target = 4.428571
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>0 &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Binary Search</li><li>Tree</li><li>Depth-First Search</li><li>Binary Search Tree</li><li>Binary Tree</li></div></div><br><div><li>👍 1840</li><li>👎 151</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValue().new Solution();
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
        public int closestValue(TreeNode root, double target) {
            int val, closest = root.val;
            while (root != null) {
                val = root.val;
                closest = Math.abs(val - target) < Math.abs(closest - target)
                        || (Math.abs(val - target) == Math.abs(closest - target) && val < closest) ? val : closest;
                root =  target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
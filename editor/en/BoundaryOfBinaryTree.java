/**
 * <p>The <strong>boundary</strong> of a binary tree is the concatenation of the <strong>root</strong>, the <strong>left boundary</strong>, the <strong>leaves</strong> ordered from left-to-right, and the <strong>reverse order</strong> of the <strong>right boundary</strong>.</p>
 *
 * <p>The <strong>left boundary</strong> is the set of nodes defined by the following:</p>
 *
 * <ul>
 * <li>The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is <strong>empty</strong>.</li>
 * <li>If a node in the left boundary and has a left child, then the left child is in the left boundary.</li>
 * <li>If a node is in the left boundary, has <strong>no</strong> left child, but has a right child, then the right child is in the left boundary.</li>
 * <li>The leftmost leaf is <strong>not</strong> in the left boundary.</li>
 * </ul>
 *
 * <p>The <strong>right boundary</strong> is similar to the <strong>left boundary</strong>, except it is the right side of the root's right subtree. Again, the leaf is <strong>not</strong> part of the <strong>right boundary</strong>, and the <strong>right boundary</strong> is empty if the root does not have a right child.</p>
 *
 * <p>The <strong>leaves</strong> are nodes that do not have any children. For this problem, the root is <strong>not</strong> a leaf.</p>
 *
 * <p>Given the <code>root</code> of a binary tree, return <em>the values of its <strong>boundary</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/11/boundary1.jpg" style="width: 299px; height: 290px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,null,2,3,4]
 * <strong>Output:</strong> [1,3,4,2]
 * <b>Explanation:</b>
 * - The left boundary is empty because the root does not have a left child.
 * - The right boundary follows the path starting from the root's right child 2 -&gt; 4.
 * 4 is a leaf, so the right boundary is [2].
 * - The leaves from left to right are [3,4].
 * Concatenating everything results in [1] + [] + [3,4] + [2] = [1,3,4,2].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/11/boundary2.jpg" style="width: 599px; height: 411px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
 * <strong>Output:</strong> [1,2,4,7,8,9,10,6,3]
 * <b>Explanation:</b>
 * - The left boundary follows the path starting from the root's left child 2 -&gt; 4.
 * 4 is a leaf, so the left boundary is [2].
 * - The right boundary follows the path starting from the root's right child 3 -&gt; 6 -&gt; 10.
 * 10 is a leaf, so the right boundary is [3,6], and in reverse order is [6,3].
 * - The leaves from left to right are [4,7,8,9,10].
 * Concatenating everything results in [1] + [2] + [4,7,8,9,10] + [6,3] = [1,2,4,7,8,9,10,6,3].
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 1353</li><li>👎 2234</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BoundaryOfBinaryTree().new Solution();
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
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            result.add(root.val);
            leftBound(result, root.left);
            leaveBound(result, root.left);
            leaveBound(result, root.right);
            rightBound(result, root.right);
            return result;
        }

        private void leftBound(List<Integer> list, TreeNode node) {
            while (node != null) {
                if (!isLeave(node)) list.add(node.val);
                node = node.left == null ? node.right : node.left;
            }
        }

        private void leaveBound(List<Integer> list, TreeNode node) {
            if (node == null) return;
            if (isLeave(node)) {
                list.add(node.val);
                return;
            }
            leaveBound(list, node.left);
            leaveBound(list, node.right);
        }

        private void rightBound(List<Integer> list, TreeNode node) {
            List<Integer> rightBound = new ArrayList<>();
            while (node != null) {
                if (!isLeave(node)) rightBound.add(node.val);
                node = node.right == null ? node.left : node.right;
            }
            Collections.reverse(rightBound);
            list.addAll(rightBound);
        }

        private boolean isLeave(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>Given the <code>root</code> of a binary tree, return <em>the lowest common ancestor (LCA) of two given nodes, </em><code>p</code><em> and </em><code>q</code>. If either node <code>p</code> or <code>q</code> <strong>does not exist</strong> in the tree, return <code>null</code>. All values of the nodes in the tree are <strong>unique</strong>.</p>
 *
 * <p>According to the <strong><a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a></strong>: "The lowest common ancestor of two nodes <code>p</code> and <code>q</code> in a binary tree <code>T</code> is the lowest node that has both <code>p</code> and <code>q</code> as <strong>descendants</strong> (where we allow <b>a node to be a descendant of itself</b>)". A <strong>descendant</strong> of a node <code>x</code> is a node <code>y</code> that is on the path from node <code>x</code> to some leaf node.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.</pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" /></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.</pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" /></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
 * <strong>Output:</strong> null
 * <strong>Explanation:</strong> Node 10 does not exist in the tree, so return null.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * <li><code>p != q</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow up:</strong>&nbsp;Can you find the LCA traversing the tree, without checking nodes existence?
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 653</li><li>👎 38</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class LowestCommonAncestorOfABinaryTreeIi {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTreeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) return null;
            TreeNode res = LCA(root, p, q);
            if (res == p) {
                return LCA(p, q, q) != null ? res : null;
            } else if (res == q) {
                return LCA(q, p, p) != null ? res : null;
            }
            return res;
        }

        private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
            if (root == p || root == q || root == null) return root;

            TreeNode left = LCA(root.left, p, q);
            TreeNode right = LCA(root.right, p, q);

            if (left == null) return right;
            if (right == null) return left;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
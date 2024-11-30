/**
 * <p>Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: “The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).”</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The LCA of nodes 5 and 1 is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" />
 * <pre>
 * <strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1,2], p = 1, q = 2
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * <li><code>p != q</code></li>
 * <li><code>p</code> and <code>q</code> will exist in the tree.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 17003</li><li>👎 440</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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
//            Intuitive but slow iterative method
/*            HashMap<TreeNode, TreeNode> parents = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    parents.put(curr.left, curr);
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    parents.put(curr.right, curr);
                    queue.add(curr.right);
                }
            }
            TreeNode p1 = p, q1 = q;
            while (p1 != q1) {
                p1 = parents.getOrDefault(p1, q);
                q1 = parents.getOrDefault(q1, p);
            }
            return p1;*/

//            Short but abstract recursive method
            if (root == p || root == q || root == null) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果左子树没有找到，则说明 p 和 q 都在右子树
            if (left == null) return right;
            // 如果右子树没有找到，则说明 p 和 q 都在左子树
            if (right == null) return left;
            // 如果左右子树都找到了 p 和 q，说明当前节点是最近公共祖先
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>Given two nodes of a&nbsp;binary tree <code>p</code> and <code>q</code>, return <em>their&nbsp;lowest common ancestor (LCA)</em>.</p>
 *
 * <p>Each node will have a reference to its parent node. The definition for <code>Node</code> is below:</p>
 *
 * <pre>
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node parent;
 * }
 * </pre>
 *
 * <p>According to the <strong><a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a></strong>: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow <b>a node to be a descendant of itself</b>)."</p>
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
 * <strong>Explanation:</strong> The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
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
 * <li><code>p</code> and <code>q</code> exist in the tree.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>Two Pointers</li><li>Tree</li><li>Binary Tree</li></div></div><br><div><li>👍 1439</li><li>👎 55</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class LowestCommonAncestorOfABinaryTreeIii {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTreeIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*// Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }*/

    class Solution {
        public Node lowestCommonAncestor(Node p, Node q) {
/*            HashMap<Integer, Node> hashMap = new HashMap<>();
            while (p != null) {
                hashMap.put(p.val, p);
                p = p.parent;
            }
            while (q != null) {
                if (hashMap.containsKey(q.val)) break;
                q = q.parent;
            }
            return q;
            */

            Node p1 = p, p2 = q;

            while (p1 != p2) {
                p1 = (p1 == null) ? q : p1.parent;
                p2 = (p2 == null) ? p : p2.parent;
            }

            return p1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
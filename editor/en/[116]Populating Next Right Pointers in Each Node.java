/**
 * You are given a perfect binary tree where all leaves are on the same level, and
 * every parent has two children. The binary tree has the following definition:
 * <p>
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * <p>
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function
 * should populate each next pointer to point to its next right node, just like in
 * Figure B. The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 * <p>
 * <p>
 * Example 2:
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
 * The number of nodes in the tree is in the range [0, 2¹² - 1].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * <p>
 * Follow-up:
 * <p>
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not
 * count as extra space for this problem.
 * <p>
 * <p>
 * Related Topics Linked List Tree Depth-First Search Breadth-First Search Binary
 * Tree 👍 9914 👎 310
 */

package com.shuzijun.leetcode.editor.en;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) return root;
            Node leftmost = root;
            while (leftmost.left != null) {
                Node head = leftmost;
                while (head != null) {
                    head.left.next = head.right;
                    if (head.next != null)
                        head.right.next = head.next.left;
                    head = head.next;
                }
                leftmost = leftmost.left;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
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
// Definition for a Node.
/*    class Node {
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
    }*/


    class Solution {
        public Node connect(Node root) {
//            层序遍历，空间O（N）次优解，可以处理非完美二叉树情况
/*            if (root == null) return root;
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                Node prev = deque.poll();
                if (prev.left != null) deque.add(prev.left);
                if (prev.right != null) deque.add(prev.right);
                for (int i = 1; i < size; i++) {
                    Node curr = deque.poll();
                    if (curr.left != null) deque.add(curr.left);
                    if (curr.right != null) deque.add(curr.right);
                    prev.next = curr;
                    prev = curr;
                }
            }
            return root;*/

//            最优解，可以处理非完美二叉树情况
            if (root == null) return root;
            Node leftMost = root;  // 记录当前层的起始节点

            while (leftMost != null) {  // 遍历每一层
                Node dummy = new Node(0);  // 用于连接下一层的虚拟头节点,dummy.next为下一层首个存在的节点
                Node prev = dummy;  // `prev` 负责构建下一层的 next 指针
                Node curr = leftMost;  // 遍历当前层

                while (curr != null) {
                    if (curr.left != null) {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                    if (curr.right != null) {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                    curr = curr.next;
                }
                leftMost = dummy.next;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
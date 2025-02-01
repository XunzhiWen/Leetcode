//Given a binary tree
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
// 
//
// Populate each next pointer to point to its next right node. If there is no 
//next right node, the next pointer should be set to NULL. 
//
// Initially, all next pointers are set to NULL. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should 
//populate each next pointer to point to its next right node, just like in Figure B. 
//The serialized output is in level order as connected by the next pointers, with 
//'#' signifying the end of each level.
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 6000]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow-up: 
//
// 
// You may only use constant extra space. 
// The recursive approach is fine. You may assume implicit stack space does not 
//count as extra space for this problem. 
// 
//
// Related Topics Linked List Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 5964 👎 331


package com.shuzijun.leetcode.editor.en;

public class PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
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
    }

    ;*/

    class Solution {
        public Node connect(Node root) {
            if (root == null) return root;
            //        使用Deque层序遍历
/*            Deque<Node> deque = new ArrayDeque<>();
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
//            最优解
            Node leftmost = root;
            while (leftmost != null) {
                Node dummy = new Node(0);
                Node prev = dummy;
                Node curr = leftmost;
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
                leftmost = dummy.next;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
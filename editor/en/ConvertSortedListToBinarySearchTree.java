/**
 * <p>Given the <code>head</code> of a singly linked list where elements are sorted in <strong>ascending order</strong>, convert <em>it to a </em><span data-keyword="height-balanced"><strong><em>height-balanced</em></strong></span> <em>binary search tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/linked.jpg" style="width: 500px; height: 388px;" />
 * <pre>
 * <strong>Input:</strong> head = [-10,-3,0,5,9]
 * <strong>Output:</strong> [0,-3,9,-10,null,5]
 * <strong>Explanation:</strong> One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = []
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in <code>head</code> is in the range <code>[0, 2 * 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Linked List</li><li>Divide and Conquer</li><li>Tree</li><li>Binary Search Tree</li><li>Binary Tree</li></div></div><br><div><li>👍 7554</li><li>👎 163</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*//  Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
    }*/

    class Solution {
        ListNode head;

        public TreeNode sortedListToBST(ListNode head) {
//            Recursion
/*            if (head == null) return null;
            if (head.next == null) return new TreeNode(head.val);
            ListNode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next=null;
            TreeNode newHead = new TreeNode(slow.val);
            newHead.left=sortedListToBST(head);
            newHead.right=sortedListToBST(slow.next);
            return newHead;*/

            if (head == null) return null;
            this.head = head;
            int len = 0;
            ListNode curr = head;
            while (curr != null) {
                len++;
                curr = curr.next;
            }
            return buildBST(0, len - 1);

        }

        private TreeNode buildBST(int start, int end) {
            if (start > end) return null;
            int mid = start + (end - start) / 2;
            TreeNode left = buildBST(start, mid - 1);
            TreeNode curr = new TreeNode(head.val);
            curr.left = left;
            head = head.next;
            curr.right = buildBST(mid + 1, end);
            return curr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
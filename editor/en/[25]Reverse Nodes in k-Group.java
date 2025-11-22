/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and
 * return the modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in the
 * end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be
 * changed.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * <p>
 * <p>
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * <p>
 * Related Topics Linked List Recursion 👍 15245 👎 789
 */

package com.shuzijun.leetcode.editor.en;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
//          判断剩下的节点还够不够k个
            ListNode curr = head;
            for (int i = 0; i < k; i++) {
                if (curr == null) {
                    return head;
                }
                curr = curr.next;
            }
//            执行k次反转，结束时
//            prev：反转后的新头（这一段的头）
//            head：反转后的新尾（原来的头）
//            curr：下一段待处理的头
//            next：反转过程中暂存下一节点
            ListNode prev = null;
            curr = head;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head.next = reverseKGroup(curr, k);
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
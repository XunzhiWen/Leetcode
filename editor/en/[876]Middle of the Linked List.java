/**
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return
 * the second one.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics Linked List Two Pointers 👍 12039 👎 385
 */

package com.shuzijun.leetcode.editor.en;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
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
    }*/

    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
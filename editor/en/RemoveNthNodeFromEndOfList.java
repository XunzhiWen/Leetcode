//Given the head of a linked list, remove the nᵗʰ node from the end of the list
//and return its head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
//
// Related Topics Linked List Two Pointers 👍 17204 👎 708


package com.shuzijun.leetcode.editor.en;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
//            if (head == null) {
//                return null;
//            }
//            ListNode temp = head;
//            int total = 0;
//            while (temp != null) {
//                temp = temp.next;
//                total++;
//            }
//            if (head.next == null) {
//                return null;
//            }
//            if (total == n) {
//                return head.next;
//            }
//            ListNode temp1 = head;
//            for (int i = 0; i < total - n - 1; i++) {
//                temp1 = temp1.next;
//            }
//            temp1.next = temp1.next.next;
//            return head;
            ListNode dummy = new ListNode(0, head);
            ListNode first = dummy;
            ListNode second = dummy;
//            Considering the last Null, we have to let first move (n+1) steps faster
            for (int i = 0; i <= n; i++) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
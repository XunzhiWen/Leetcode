//Given the head of a linked list, reverse the nodes of the list k at a time,
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
//
// Related Topics Linked List Recursion 👍 12674 👎 625


package com.shuzijun.leetcode.editor.en;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        ListNode result = solution.reverseKGroup(head, 3);
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
            ListNode curTail = head;
            ListNode curHead = head;
            ListNode newHead = head;
            ListNode preTail = head;
            int i = 0, count = 0;
            while (curTail != null) {
                i++;
                if (i == k) {
                    ListNode temp = curHead;
                    curHead = reverse(curHead, k);
                    curTail = temp;

                    if (count == 0) {
                        newHead = curHead;
                        preTail = curTail;
                    } else {
                        preTail.next = curHead;
                        preTail = curTail;
                    }
                    curHead = curTail.next;
                    i = 0;
                    count++;
                }
                curTail = curTail.next;

            }
            return newHead;
        }

        private ListNode reverse(ListNode head, int k) {
            ListNode cur = head;
            int i = 0;
            while (cur != null && cur.next != null && i < k - 1) {
                i++;
                ListNode curHead = head;
                head = cur.next;
                cur.next = cur.next.next;
                head.next = curHead;
            }
            return head;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
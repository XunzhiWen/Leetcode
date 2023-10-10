//Given a linked list, swap every two adjacent nodes and return its head. You
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics Linked List Recursion 👍 11291 👎 409


package com.shuzijun.leetcode.editor.en;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                ListNode node1=cur.next;
                ListNode node2 =cur.next.next;
                ListNode node3=cur.next.next.next;
                cur.next=node2;
                node1.next=node3;
                node2.next=node1;
                cur=cur.next.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//Given the head of a singly linked list, return true if it is a palindrome or
//false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in 
//O(n) time and 
//O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 15231 👎 817


package com.shuzijun.leetcode.editor.en;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            /* Array can also do the same job
             *
             * Another Elegant way is recursion. */
            Stack<Integer> stack = new Stack<>();
            ListNode temp1 = head;
            ListNode temp2 = head;
            boolean result = true;
            int n = 0;
            while (temp1 != null) {
                stack.push(temp1.val);
                temp1 = temp1.next;
                n++;
            }
            for (int i = 0; i < n / 2; i++) {
                if (temp2.val != stack.pop()) {
                    result = false;
                    break;
                }
                temp2 = temp2.next;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
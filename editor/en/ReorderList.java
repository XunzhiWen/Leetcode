//You are given the head of a singly linked-list. The list can be represented
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 11426 👎 427


package com.shuzijun.leetcode.editor.en;

public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//  Definition for singly-linked list.
/*    public class ListNode {
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
        public void reorderList(ListNode head) {
//            Stack
/*            if (head == null) return;
            Stack<ListNode> stack = new Stack<>();
            ListNode curr = head;
            while (curr != null) {
                stack.push(curr);
                curr = curr.next;
            }
            int n = stack.size();
            for (int i = 0; i < n / 2; i++) {
                ListNode tail = stack.pop();
                tail.next = head.next;
                head.next = tail;
                head = tail.next;
            }
            head.next = null;*/

//            Two pointers
            if (head == null || head.next == null) return;

            // Step 1: 找到链表中点
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2: 反转后半部分链表
            ListNode prev = null, curr = slow.next;
            slow.next = null; // 断开前后两部分
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            // Step 3: 合并前半部分和后半部分
            ListNode firstHalf = head, secondHalf = prev;
            while (secondHalf != null) {
                ListNode temp1 = firstHalf.next;
                ListNode temp2 = secondHalf.next;

                firstHalf.next = secondHalf;
                secondHalf.next = temp1;

                firstHalf = temp1;
                secondHalf = temp2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
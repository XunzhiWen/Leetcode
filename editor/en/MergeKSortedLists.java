//You are given an array of k linked-lists lists, each linked-list is sorted in
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 18330 👎 654


package com.shuzijun.leetcode.editor.en;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            int k = lists.length;
            if (k==0){
                return null;
            }
            int interval = 1;
            while (interval < k) {
                for (int i = 0; i < k - interval; i += interval * 2) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
                }
                interval*=2;
            }
            return lists[0];
        }

        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode head0 = head;
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    head.next = list2;
                    break;
                }
                if (list2 == null) {
                    head.next = list1;
                    break;
                }
                if (list1.val <= list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            }
            return head0.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
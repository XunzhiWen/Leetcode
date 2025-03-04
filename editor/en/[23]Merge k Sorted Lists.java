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
//Sort 👍 20050 👎 741


package com.shuzijun.leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*

    //  Definition for singly-linked list.
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
*/

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }
            ListNode head = new ListNode();
            ListNode cur = head;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                cur.next = node;
                cur = cur.next;

                if (node.next != null) {
                    pq.offer(node.next);
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
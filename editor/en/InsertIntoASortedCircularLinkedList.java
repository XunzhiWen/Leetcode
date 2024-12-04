//Given a Circular Linked List node, which is sorted in non-descending order,
//write a function to insert a value insertVal into the list such that it remains a 
//sorted circular list. The given node can be a reference to any single node in 
//the list and may not necessarily be the smallest value in the circular list. 
//
// If there are multiple suitable places for insertion, you may choose any 
//place to insert the new value. After the insertion, the circular list should remain 
//sorted. 
//
// If the list is empty (i.e., the given node is null), you should create a new 
//single circular list and return the reference to that single node. Otherwise, 
//you should return the originally given node. 
//
// 
// Example 1: 
//
// 
// 
//Input: head = [3,4,1], insertVal = 2
//Output: [3,4,1,2]
//Explanation: In the figure above, there is a sorted circular list of three 
//elements. You are given a reference to the node with value 3, and we need to 
//insert 2 into the list. The new node should be inserted between node 1 and node 3. 
//After the insertion, the list should look like this, and we should still return 
//node 3.
// 
//
//
//
//
// Example 2: 
//
// 
//Input: head = [], insertVal = 1
//Output: [1]
//Explanation: The list is empty (given head is null). We create a new single 
//circular list and return the reference to that single node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], insertVal = 0
//Output: [1,0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁶ <= Node.val, insertVal <= 10⁶ 
// 
//
// Related Topics Linked List 👍 1252 👎 789


package com.shuzijun.leetcode.editor.en;

public class InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        Solution solution = new InsertIntoASortedCircularLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.
/*
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
*/


    class Solution {
        public Node insert(Node head, int insertVal) {
/*            if (head == null) {
                Node newnode = new Node(insertVal);
                newnode.next = newnode;
                return newnode;
            }
            Node curr = head;
            while (true) {
                // Case 1: 插入值位于两个节点之间（普通升序插入）
                if (curr.val <= insertVal && insertVal <= curr.next.val) {
                    break;
                }
                // Case 2: 跨越最小值和最大值插入
                if (curr.val > curr.next.val && (insertVal >= curr.val || insertVal <= curr.next.val)) {
                    break;
                }
                // 移动到下一个节点
                curr = curr.next;
                // Case 3: 遍历一圈未找到合适位置（所有节点值相同或无法匹配）
                if (curr == head) {
                    break;
                }
            }

            // 插入新节点
            Node newNode = new Node(insertVal, curr.next);
            curr.next = newNode;
            return head;*/

            if (head == null) {
                Node newNode = new Node(insertVal);
                newNode.next = newNode;
                return newNode;
            }

            Node curr = head;

            while (true) {
                if (curr.val <= insertVal && curr.next.val >= insertVal) break;
                if ((curr.val > curr.next.val) && (curr.val <= insertVal || curr.next.val >= insertVal)) break;
                curr = curr.next;
                if (curr == head) break;
            }
            curr.next = new Node(insertVal, curr.next);
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>A linked list of length <code>n</code> is given such that each node contains an additional random pointer, which could point to any node in the list, or <code>null</code>.</p>
 *
 * <p>Construct a <a href="https://en.wikipedia.org/wiki/Object_copying#Deep_copy" target="_blank"><strong>deep copy</strong></a> of the list. The deep copy should consist of exactly <code>n</code> <strong>brand new</strong> nodes, where each new node has its value set to the value of its corresponding original node. Both the <code>next</code> and <code>random</code> pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. <strong>None of the pointers in the new list should point to nodes in the original list</strong>.</p>
 *
 * <p>For example, if there are two nodes <code>X</code> and <code>Y</code> in the original list, where <code>X.random --&gt; Y</code>, then for the corresponding two nodes <code>x</code> and <code>y</code> in the copied list, <code>x.random --&gt; y</code>.</p>
 *
 * <p>Return <em>the head of the copied linked list</em>.</p>
 *
 * <p>The linked list is represented in the input/output as a list of <code>n</code> nodes. Each node is represented as a pair of <code>[val, random_index]</code> where:</p>
 *
 * <ul>
 * <li><code>val</code>: an integer representing <code>Node.val</code></li>
 * <li><code>random_index</code>: the index of the node (range from <code>0</code> to <code>n-1</code>) that the <code>random</code> pointer points to, or <code>null</code> if it does not point to any node.</li>
 * </ul>
 *
 * <p>Your code will <strong>only</strong> be given the <code>head</code> of the original linked list.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e1.png" style="width: 700px; height: 142px;" />
 * <pre>
 * <strong>Input:</strong> head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <strong>Output:</strong> [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e2.png" style="width: 700px; height: 114px;" />
 * <pre>
 * <strong>Input:</strong> head = [[1,1],[2,1]]
 * <strong>Output:</strong> [[1,1],[2,1]]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/12/18/e3.png" style="width: 700px; height: 122px;" /></strong></p>
 *
 * <pre>
 * <strong>Input:</strong> head = [[3,null],[3,0],[3,null]]
 * <strong>Output:</strong> [[3,null],[3,0],[3,null]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= n &lt;= 1000</code></li>
 * <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * <li><code>Node.random</code> is <code>null</code> or is pointing to some node in the linked list.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Hash Table</li><li>Linked List</li></div></div><br><div><li>👍 14212</li><li>👎 1525</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
/*    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }*/

    class Solution {
//        HashMap<Node, Node> visitedHash = new HashMap<>();

        public Node copyRandomList(Node head) {
//            O(N) Iterative
/*            if (head == null) return null;
            Node newHead = new Node(head.val);
            Node curr = head;
            Node newCurr = newHead;
            HashMap<Node, Node> hashMap = new HashMap<>();
            hashMap.put(head, newHead);
            while (curr != null) {
                if (curr.next != null) {
                    if (hashMap.containsKey(curr.next)) {
                        newCurr.next = hashMap.get(curr.next);
                    } else {
                        Node newCopy = new Node(curr.next.val);
                        newCurr.next = newCopy;
                        hashMap.put(curr.next, newCopy);
                    }
                }
                if (curr.random != null) {
                    if (hashMap.containsKey(curr.random)) {
                        newCurr.random = hashMap.get(curr.random);
                    } else {
                        Node newCopy = new Node(curr.random.val);
                        newCurr.random = newCopy;
                        hashMap.put(curr.random, newCopy);
                    }
                }
                curr = curr.next;
                newCurr = newCurr.next;

            }
            return newHead;*/


//            O(N) Recursive
/*            if (head == null) return null;

            if (this.visitedHash.containsKey(head)) {
                return visitedHash.get(head);
            }

            Node newHead = new Node(head.val);
            visitedHash.put(head, newHead);

            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);

            return newHead;*/

//            O(1) Iterative
            if (head == null) return null;

            // 第一步：创建交织链表
            Node ptr = head;
            while (ptr != null) {
                Node newNode = new Node(ptr.val);
                newNode.next = ptr.next;
                ptr.next = newNode;
                ptr = newNode.next;
            }

            // 第二步：复制 random 指针
            ptr = head;
            while (ptr != null) {
                ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
                ptr = ptr.next.next;
            }

            // 第三步：分离链表
            Node ptr_old_list = head;
            Node ptr_new_list = head.next;
            Node head_new = head.next;
            while (ptr_old_list != null) {
                ptr_old_list.next = ptr_old_list.next.next;
                ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
                ptr_old_list = ptr_old_list.next;
                ptr_new_list = ptr_new_list.next;
            }

            return head_new;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
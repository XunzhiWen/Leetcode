//Given the root of a binary tree, the value of a target node target, and an
//integer k, return an array of the values of all nodes that have a distance k from 
//the target node. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 
//5) have values 7, 4, and 1.
// 
//
// Example 2: 
//
// 
//Input: root = [1], target = 1, k = 3
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 500]. 
// 0 <= Node.val <= 500 
// All the values Node.val are unique. 
// target is the value of one of the nodes in the tree. 
// 0 <= k <= 1000 
// 
//
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Binary Tree 👍 11209 👎 239


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            HashMap<Integer, TreeNode> parent = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    parent.put(node.left.val, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right.val, node);
                    queue.offer(node.right);
                }
            }

            HashMap<Integer, Integer> visited = new HashMap<>();
            queue.offer(target);
            while (k > 0 && !queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    visited.put(node.val, 1);

                    if (node.left != null && !visited.containsKey(node.left.val)) {
                        queue.offer(node.left);
                    }
                    if (node.right != null && !visited.containsKey(node.right.val)) {
                        queue.offer(node.right);
                    }
                    if (parent.containsKey(node.val) && !visited.containsKey(parent.get(node.val).val)) {
                        queue.offer(parent.get(node.val));
                    }
                }
                k--;
            }
            while (!queue.isEmpty()) {
                res.add(queue.poll().val);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
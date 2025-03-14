//Given the root of a binary tree, return the vertical order traversal of its
//nodes' values. (i.e., from top to bottom, column by column). 
//
// If two nodes are in the same row and column, the order should be from left 
//to right. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[9],[3,15],[20],[7]]
// 
//
// Example 2: 
// 
// 
//Input: root = [3,9,8,4,0,1,7]
//Output: [[4],[9],[3,0,1],[8],[7]]
// 
//
// Example 3: 
// 
// 
//Input: root = [1,2,3,4,10,9,11,null,5,null,null,null,null,null,null,null,6]
//Output: [[4],[2,5],[1,10,9,6],[3],[11]]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Hash Table Tree Depth-First Search Breadth-First Search 
//Sorting Binary Tree 👍 3308 👎 342


package com.shuzijun.leetcode.editor.en;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeVerticalOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
/*
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
*/

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> output = new ArrayList();
            if (root == null) {
                return output;
            }

            Map<Integer, ArrayList> columnTable = new HashMap();
            // Pair of node and its column offset
            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
            int column = 0;
            queue.offer(new Pair(root, column));

            int minColumn = 0, maxColumn = 0;

            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> p = queue.poll();
                root = p.getKey();
                column = p.getValue();

                if (root != null) {
                    if (!columnTable.containsKey(column)) {
                        columnTable.put(column, new ArrayList<Integer>());
                    }
                    columnTable.get(column).add(root.val);
                    minColumn = Math.min(minColumn, column);
                    maxColumn = Math.max(maxColumn, column);

                    queue.offer(new Pair(root.left, column - 1));
                    queue.offer(new Pair(root.right, column + 1));
                }
            }

            for(int i = minColumn; i < maxColumn + 1; ++i) {
                output.add(columnTable.get(i));
            }

            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
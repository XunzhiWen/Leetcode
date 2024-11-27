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

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeVerticalOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
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

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;
            HashMap<Integer, List<TreeNode>> columnIdx = new HashMap<>();
            Deque<Pair<Integer, TreeNode>> deque = new LinkedList<>();
            int min = 0, max = 0;
            columnIdx.put(0, new LinkedList<>());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
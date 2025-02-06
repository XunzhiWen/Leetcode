//Given the root of a binary tree and an integer targetSum, return all root-to-
//leaf paths where the sum of the node values in the path equals targetSum. Each 
//path should be returned as a list of the node values, not node references. 
//
// A root-to-leaf path is a path starting from the root and ending at any leaf 
//node. A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//Explanation: There are two paths whose sum equals targetSum:
//5 + 4 + 11 + 2 = 22
//5 + 8 + 4 + 5 = 22
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics Backtracking Tree Depth-First Search Binary Tree 👍 8186 👎 16
//0


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            backTrack(root, targetSum, new ArrayList<>(), res);
            return res;
        }

        private void backTrack(TreeNode node, int remain, List<Integer> curr, List<List<Integer>> res) {
            curr.add(node.val);
            if (node.left == null && node.right == null) {
                if (remain == node.val) {
//                    添加结果时要值传递而不能地址传递
                    res.add(new ArrayList<>(curr));
                }
                return;
            }
            if (node.left != null) {
//                注意remain的含义
                backTrack(node.left, remain - node.val, curr, res);
                curr.remove(curr.size() - 1);
            }
            if (node.right != null) {
                backTrack(node.right, remain - node.val, curr, res);
                curr.remove(curr.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
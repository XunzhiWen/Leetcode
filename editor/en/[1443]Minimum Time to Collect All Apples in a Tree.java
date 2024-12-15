package com.shuzijun.leetcode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which
 * has some apples in their vertices. You spend 1 second to walk over one edge of
 * the tree. Return the minimum time in seconds you have to spend to collect all
 * apples in the tree, starting at vertex 0 and coming back to this vertex.
 * <p>
 * The edges of the undirected tree are given in the array edges, where edges[i] =
 * [ai, bi] means that exists an edge connecting the vertices ai and bi.
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true means that
 * vertex i has an apple; otherwise, it does not have any apple.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have
 * an apple. One optimal path to collect all apples is shown by the green arrows.
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have
 * an apple. One optimal path to collect all apples is shown by the green arrows.
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,false,false,false,false,false]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 10⁵
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * hasApple.length == n
 * <p>
 * <p>
 * Related Topics Hash Table Tree Depth-First Search Breadth-First Search 👍 3683
 * 👎 325
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return DFS(0, -1, adj, hasApple);

    }

    private int DFS(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int totalTime = 0;

        for (int child : adj.get(node)) {
            if (child == parent) continue;
            int childTime = DFS(child, node, adj, hasApple);

            if (childTime > 0 || hasApple.get(child)) totalTime += childTime + 2;
        }
        return totalTime;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

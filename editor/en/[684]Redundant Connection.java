/**
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi] indicates that there
 * is an edge between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in the
 * input.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 * <p>
 * <p>
 * Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 7048
 * 👎 446
 */

package com.shuzijun.leetcode.editor.en;

public class RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new RedundantConnection().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UnionFind uf = new UnionFind(edges.length);
            int i = 0;
            for (; i < edges.length; i++) {
                if (uf.isSame(edges[i][0], edges[i][1])){
                    break;
                }
                uf.union(edges[i][0], edges[i][1]);
            }
            return edges[i];
        }
    }

    class UnionFind {
        private int[] rank;
        private int[] root;

        public UnionFind(int n) {
            rank = new int[n + 1];
            root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootX] = rootY;
                rank[rootY]++;
            }
        }

        public boolean isSame(int x, int y) {
            return find(x) == find(y);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
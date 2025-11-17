/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled
 * from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D
 * integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge
 * between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
 * and no vertex has an edge to itself.
 * <p>
 * You want to determine if there is a valid path that exists from vertex source
 * to vertex destination.
 * <p>
 * Given edges and the integers n, source, and destination, return true if there
 * is a valid path from source to destination, or false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination =
 * 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 2 * 10⁵
 * 0 <= edges.length <= 2 * 10⁵
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 * <p>
 * <p>
 * Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 4208
 * 👎 245
 */

package com.shuzijun.leetcode.editor.en;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        Solution solution = new FindIfPathExistsInGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < edges.length; i++) {
                uf.union(edges[i][0], edges[i][1]);
            }

            return uf.isSame(source, destination);
        }


    }

    class UnionFind {
        private int[] rank;
        private int[] root;

        public UnionFind(int n) {
            rank = new int[n];
            root = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != root[x]) {
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
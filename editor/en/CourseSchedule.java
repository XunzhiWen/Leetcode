//There are a total of numCourses courses you have to take, labeled from 0 to
//numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
// 
//
// 
// For example, the pair [0, 1], indicates that to take course 0 you have to 
//first take course 1. 
// 
//
// Return true if you can finish all courses. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
// 
//
// Example 2: 
//
// 
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you 
//should also have finished course 1. So it is impossible.
// 
//
// 
// Constraints: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// All the pairs prerequisites[i] are unique. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 16599 👎 768


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            BFS
/*            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) queue.add(i);
            }

            int visitedCourses = 0;
            while (!queue.isEmpty()) {
                int currCourse = queue.poll();
                visitedCourses++;
                for (int nextCourse : graph.get(currCourse)) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) queue.add(nextCourse);
                }
            }
            return visitedCourses == numCourses;*/

            // Step 1: 构建图
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            }

            // Step 2: 初始化访问状态数组
            int[] visited = new int[numCourses];

            // Step 3: 对每个课程进行 DFS
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(graph, visited, i)) {
                    return false; // 如果检测到环，直接返回 false
                }
            }
            return true; // 所有课程都无环
        }

        private boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
            if (visited[course] == 1) {
                return false; // 检测到环
            }
            if (visited[course] == 2) {
                return true; // 已经访问过，无需重复处理
            }

            // 标记当前节点正在访问
            visited[course] = 1;

            // 递归访问所有相邻节点
            for (int nextCourse : graph.get(course)) {
                if (!dfs(graph, visited, nextCourse)) {
                    return false; // 如果发现环，直接返回 false
                }
            }

            // 标记当前节点及其子节点访问完成
            visited[course] = 2;

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
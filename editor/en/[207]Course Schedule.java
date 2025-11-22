/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
 * bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * <p>
 * <p>
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * <p>
 * <p>
 * Related Topics Depth-First Search Breadth-First Search Graph Topological Sort ?
 * ? 17616 👎 848
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            int n = prerequisites.length;
            HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                inDegree[prerequisites[i][0]]++;
                hashMap.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);
            }

            Queue<Integer> q = new ArrayDeque<>();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) q.add(i);
            }
            while (!q.isEmpty()) {
                int currCourse = q.poll();
                if (hashMap.containsKey(currCourse)) {
                    for (int course : hashMap.get(currCourse)) {
                        inDegree[course]--;
                        if (inDegree[course] == 0) q.add(course);
                    }
                }
                res.add(currCourse);
            }
            return numCourses == res.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
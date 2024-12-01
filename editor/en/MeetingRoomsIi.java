/**
 * <p>Given an array of meeting time intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, return <em>the minimum number of conference rooms required</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> intervals = [[0,30],[5,10],[15,20]]
 * <strong>Output:</strong> 2
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> intervals = [[7,10],[2,4]]
 * <strong>Output:</strong> 1
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;=&nbsp;intervals.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Two Pointers</li><li>Greedy</li><li>Sorting</li><li>Heap (Priority Queue)</li><li>Prefix Sum</li></div></div><br><div><li>👍 7022</li><li>👎 167</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class MeetingRoomsIi {
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
//            PQ method
/*            Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
            PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

            pq.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= pq.peek()[1]) {
                    pq.poll();
                }
                pq.add(intervals[i]);
            }
            return pq.size();*/

//            Two pointers
            Integer[] start = new Integer[intervals.length];
            Integer[] end = new Integer[intervals.length];

            for (int i = 0; i < intervals.length; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            Arrays.sort(start);
            Arrays.sort(end);

            int endPtr = 0, meetingRoom = 0;

            for (int startPtr = 0; startPtr < start.length; startPtr++) {
                if (start[startPtr] >= end[endPtr]) {
                    endPtr++;
                    meetingRoom--;
                }
                meetingRoom++;
            }
            return meetingRoom;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
  //There are n persons on a social media website. You are given an integer array 
//ages where ages[i] is the age of the iᵗʰ person. 
//
// A Person x will not send a friend request to a person y (x != y) if any of 
//the following conditions is true: 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// Otherwise, x will send a friend request to y. 
//
// Note that if x sends a request to y, y will not necessarily send a request 
//to x. Also, a person will not send a friend request to themself. 
//
// Return the total number of friend requests made. 
//
// 
// Example 1: 
//
// 
//Input: ages = [16,16]
//Output: 2
//Explanation: 2 people friend request each other.
// 
//
// Example 2: 
//
// 
//Input: ages = [16,17,18]
//Output: 2
//Explanation: Friend requests are made 17 -> 16, 18 -> 17.
// 
//
// Example 3: 
//
// 
//Input: ages = [20,30,100,110,120]
//Output: 3
//Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
// 
//
// 
// Constraints: 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= ages[i] <= 120 
// 
//
// Related Topics Array Two Pointers Binary Search Sorting 👍 795 👎 1232

  
  package com.shuzijun.leetcode.editor.en;
  public class FriendsOfAppropriateAges{
      public static void main(String[] args) {
           Solution solution = new FriendsOfAppropriateAges().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages); // 对年龄数组进行排序
        int left = 0, prev = 0, result = 0;

        for (int i = 1; i < ages.length; i++) {
            // 找到第一个满足 age[y] > 0.5 * age[x] + 7 的 y
            while (left < i && ages[left] <= 0.5 * ages[i] + 7) {
                left++;
            }

            // prev 用于跳过与当前年龄不同的人
            while (prev < i && ages[i] != ages[prev]) {
                prev++;
            }

            // 处理与当前年龄相同的人（避免重复计算）
            if (ages[i] == ages[prev] && ages[i] > 0.5 * ages[i] + 7) {
                result += i - prev; // 累加相同年龄的好友请求数
            }

            // 累加其他满足条件的好友请求数
            result += i - left;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
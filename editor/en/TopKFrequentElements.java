//Given an integer array nums and an integer k, return the k most frequent
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 17749 👎 683


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

//            Heap method
/*            HashMap<Integer, Integer> countList = new HashMap<>();
            for (int num : nums) {
                countList.put(num, countList.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
            for (int key : countList.keySet()) {
                pq.add(new int[]{key, countList.get(key)});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int n = pq.size();
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
//                It's dangerous to modify the size of the data structure in a for loop while
//                it's the signal of the loop (like the size)
                result[i] = pq.poll()[0];
            }
            return result;*/

//            QuickSort Method

            HashMap<Integer, Integer> countList = new HashMap<>();
            for (int num : nums) {
                countList.put(num, countList.getOrDefault(num, 0) + 1);
            }
            int[] unique = new int[countList.size()];
            int index = 0;
            for (int key : countList.keySet()) {
                unique[index] = key;
                index++;
            }

            int left = 0, right = unique.length - 1, partition = 0;
            while (left < right) {
                partition = partition(unique, left, right, countList);
                if (partition > k - 1) right = partition - 1;
                else if (partition < k - 1) left = partition + 1;
                else break;
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = unique[i];
            }
            return result;
        }

        private int partition(int[] unique, int left, int right, HashMap<Integer, Integer> hashMap) {
            int pivotIndex = left + (int) (Math.random() * (right - left + 1));
            swap(unique, pivotIndex, right);
            int pivot = hashMap.get(unique[right]);

            int i = left;
            for (int j = left; j < right; j++) {
                if (hashMap.get(unique[j]) > pivot) {
                    swap(unique, i, j);
                    i++;
                }
            }
            swap(unique, i, right);
            return i;

        }

        private void swap(int[] unique, int i, int j) {
            int temp = unique[i];
            unique[i] = unique[j];
            unique[j] = temp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
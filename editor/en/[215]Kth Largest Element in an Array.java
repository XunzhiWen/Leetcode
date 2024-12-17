/**
 * Given an integer array nums and an integer k, return the kᵗʰ largest element in
 * the array.
 * <p>
 * Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ
 * distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= k <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Divide and Conquer Sorting Heap (Priority Queue)
 * Quickselect 👍 17478 👎 917
 */

package com.shuzijun.leetcode.editor.en;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, k-1, 0, nums.length - 1);
        }

        private int quickSelect(int[] nums, int k, int left, int right) {
            if (left == right) return nums[left];
            int pivot = partition(nums, left, right);
            if (pivot == k ) return nums[pivot];
            else if (pivot < k) return quickSelect(nums, k, pivot + 1, right);
            else return quickSelect(nums, k, left, pivot - 1);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = left + (int) (Math.random() * (right - left + 1));
            swap(nums, pivot, right);
            int index = left;
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[right]) {
                    swap(nums, i, index);
                    index++;
                }
            }
            swap(nums, right, index);
            return index;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>Implement the <code>RandomizedSet</code> class:</p>
 *
 * <ul>
 * <li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
 * <li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
 * <li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
 * <li><code>int getRandom()</code> Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
 * </ul>
 *
 * <p>You must implement the functions of the class such that each function works in&nbsp;<strong>average</strong>&nbsp;<code>O(1)</code>&nbsp;time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * <strong>Output</strong>
 * [null, true, false, true, 2, true, false, 2]
 *
 * <strong>Explanation</strong>
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
 * <li>At most <code>2 *&nbsp;</code><code>10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
 * <li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Math</li><li>Design</li><li>Randomized</li></div></div><br><div><li>👍 9400</li><li>👎 644</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        Solution solution = new InsertDeleteGetrandomO1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        HashMap<Integer, Integer> hashMap;
        ArrayList<Integer> arrayList;

        public RandomizedSet() {
            hashMap = new HashMap<>();
            arrayList = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (hashMap.containsKey(val)) return false;
            arrayList.add(val);
            hashMap.put(val, arrayList.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) return false;
            int idx = hashMap.get(val);
            int lastNum = arrayList.get(arrayList.size() - 1);
            arrayList.set(idx, lastNum);
            hashMap.put(lastNum, idx);
            arrayList.remove(arrayList.size() - 1);
            hashMap.remove(val);
            return true;
        }


        public int getRandom() {
            return arrayList.get((int) (Math.random() * arrayList.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
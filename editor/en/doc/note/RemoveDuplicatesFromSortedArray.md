给定一个非降序排列的数组，返回其中不重复的数字个数，要求在原数组修改，且原数组前k项必须为k个不重复项。
这道题是典型的双指针题，使用快慢指针。初见时思路差了一层，不应该想着交换重复项和后面的非重复项，而应该直接将非重复项覆盖重复项，如此一来前k项均为非重复项了。

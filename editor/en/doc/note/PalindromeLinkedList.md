检查一个单向链接的链表是否是回文的。

默认解法很好想，复制一遍即可。递归解法比较巧妙，但是在内存占用上并不占便宜。唯一的内存o（1）解法要在原链表中将后半段反转，反转的算法非常精妙，用两个节点跟踪当前节点和前一个节点（稍后会变成后一个节点），用一个临时节点存放后一个节点的地址。此外，这道题也提供了一个单向链表寻找重点的方法：两指针赛跑，慢的一次一个节点，快的一次两个节点，最终慢的节点会在中点（左）节点停下。

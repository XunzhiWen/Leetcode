检查杂志字符串里面的字母够不够组成绑票条字符串。

这道题应该使用哈希图而不是哈希表，因为当我们用字母做键出现次数做值时，每个键只对应一个值。当且仅当需要每个键对应多个值时才使用哈希表。哈希表可以创建一个，根据另外一个字符串做减法，也可以创建两个做加法再对比，区别不大。
此外，注意Java的string中有一个函数indexOf(char)可以返回char对应的索引，没有则返回-1，可以用于检测并删除某个字母是否在另外一个字符串。
还有一个思路是将两个字符串按字母顺序排列后压入栈，分别对比两个栈的字母，根据字母先后顺序判断真伪。
最后，注意一些常用方法、结构的时间、空间复杂度，如快排O(nlogn)，哈希表的插入和搜索都是O（1）等。
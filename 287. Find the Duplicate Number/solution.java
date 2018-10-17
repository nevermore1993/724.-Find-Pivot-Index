// 因为每个节点的值在1-n的范围内，所以可以将元素视作一个个节点，元素的index代表节点的index，元素存的值代表当前节点指向的下一个节点index
// 如果不存在重复值，那么也就是说每一个节点指向的都是不同的节点，也就不存在闭环；反之，如果存在重复的值，那么就存在至少两个节点指向同一个节点，也就形成
// 了闭环。那么这个问题就变成了寻找闭环入口的问题。可以使用 Floyd's Tortoise and Hare 方法。
// 基本思想就是从头开始设置两个指针，一个比另一个快一倍，那么在遍历的过程中，快的指针总会在环中追上慢的指针，如果追上了，就代表存在闭环，这是第一阶段
// 快慢指针在这一阶段相遇的节点需要记录下来。第二阶段就是让一个指针从头开始，另一个指针从第一阶段的相遇点开始遍历，同样的速度，下一次相遇时就会是在
// 环的入口处
// 假设 非环部分长度为 F， 环入口到第一次相遇点长度为 a， 第一次相遇点回到环入口长度为 b， 则 （F + a）* 2 = F + a + b + a
// 其中 （F + a）是第一阶段慢节点走的长度， F + a + b + a是第一阶段快节点走的长度
// 计算可得 F = b，也就是说两者会在环入口处相遇
// https://blog.csdn.net/xyzxiaoxiong/article/details/78761940
// https://leetcode.com/problems/find-the-duplicate-number/solution/#
class Solution {
    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}

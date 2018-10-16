// 两次遍历，第一次每一位存当前位之前所有位的乘积，这样遍历一次后，每一位还缺少其之后的所有位的乘积，所以第二次以第一次的结果为基础，
// 从后向前遍历，乘以之后的乘积，最终的结果就是除了自己的乘积。
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

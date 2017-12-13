class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();   //三个hashmap，分别存储每一个元素第一次出现的index，最后一次出现的index和次数

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);    //对每一个元素，第一次出现时设置left，新出现一次就设置一次right，以及count
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());    //确定degree
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);    //对每一个元素，如果degree最大，判断subarray长度，与当前长度比较
            }
        }
        return ans;
    }
}

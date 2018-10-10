// solution 1, rotate 1 step at a time, O(1)space, but O(n^2) time
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}

//solution 2, simply swap two subarray
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        k = k % nums.length;
        int[] first = new int[nums.length - k];
        int[] second = new int[k];
        System.arraycopy(nums, 0, first, 0, nums.length - k);
        System.arraycopy(nums, nums.length - k, second, 0, k);
        for (int i = 0; i < k; i++) {
            nums[i] = second[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            nums[k + i] = first[i];
        }
    }
}

// solution 3, reverse whole array, then reverse two subarrays
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

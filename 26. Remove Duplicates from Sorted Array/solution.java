// during the iteration, store the unique number count, use it as the index to move element
class Solution {
    public int removeDuplicates(int[] nums) {
        int number = 0;
        if (nums.length == 0)
            return 0;
        
        int temp = nums[0];
        number++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                number++;
                nums[number - 1] = nums[i];
                temp = nums[i];
            }
        }
        return number;
    }
}


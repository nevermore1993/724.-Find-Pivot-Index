// traverse array, move 0 to the beginnig, 2 to the end, 1 remain its place. keep record of three flags, the last index of 0s 
// at the begging, the first index of 2s at the end, and current index. Point here is to update start and end every time before
// swap
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1)
            return;
        
        int start = -1, end = nums.length, current = 0;
        
        while (current < end) {
        
            if (nums[current] == 0) {
                if (nums[start + 1] == 0) {
                    current++;
                    start++;
                } else {
                    swap(nums, current, start + 1);
                    start++;
                }  
            } else if (nums[current] == 2) {
                if (nums[end - 1] == 2) {
                    end--;
                } else {
                    swap(nums, current, end - 1);
                    end--;
                }
            } else
                current++;
        }
    }
    
    public void swap(int[] nums, int m, int n) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}

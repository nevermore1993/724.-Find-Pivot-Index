//the missing positive must in range of 1 --- nums.length, so traversal array once, swap numbers within that range to right 
//position, ignore numbers not in that range and numbers already in right position. Then traversal again, get the first number
// that is in the range and not in the right position.
 

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) 
                i++;
            else if(nums[nums[i]-1] != nums[i]) 
                swap(nums, i, nums[i]-1);
            else 
                i++;                
        }
        i = 0;
        while (i < nums.length && nums[i] == (i + 1))
            i++;
        return i + 1;
        
    }
    
    public void swap(int[] nums, int index1, int index2) {
        int i = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = i;
    }
}

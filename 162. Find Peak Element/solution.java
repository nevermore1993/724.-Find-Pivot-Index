// find peak, if nums[i] < nums[i + 1] && nums[i] > nums[i - 1]. take nums[-1] and nums[length] as special case.
// there must be a least one peak as long as nums[i] ≠ nums[i+1]
class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                if (i + 1 == nums.length)
                    return i;
                else {
                    if (nums[i] > nums[i + 1])
                        return i;
                }
            } else if (nums[i] > nums[i - 1]) {
                if (i + 1 == nums.length)
                    return i;
                else {
                    if (nums[i] > nums[i + 1])
                        return i;
                }
            }
        }
        return nums.length - 1;
    }
}

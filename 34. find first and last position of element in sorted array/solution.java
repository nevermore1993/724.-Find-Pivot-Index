// my solution using binary search to find target 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] {-1, -1};
        return getResult(nums, target, 0, nums.length -1);
    }
    
    public int[] getResult(int[] nums, int target, int start, int end) {
        int a, b;
        if (end < start)
            return new int[] {-1, -1};
        if (nums[start] == nums[end] && nums[start] != target) 
            return new int[] {-1, -1};
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            a = mid;
            b = mid;
            while ((a - 1) >= 0 && nums[a - 1] == target)
                a -= 1;
            while ((b + 1) < nums.length && nums[b + 1] == target)
                b += 1;
            return new int[] {a, b};
        } else if (nums[mid] > target) {
            return getResult(nums, target, start, mid - 1);
        } else {
            return getResult(nums, target, mid + 1, end);
        }
    }
}


// suggest solution, using binary search to find left/right most index of target
class Solution {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}

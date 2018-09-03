// key point here is to reorganize nums[], move the used number to the front, so the rest numbers are new 
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {    //  generate first integer of list
            List<Integer> subResult = new ArrayList<>();
            subResult.add(nums[i]);
            int[] nums1 = new int[nums.length];
            System.arraycopy(nums, 0, nums1, 0, nums.length);
            swap(nums1, 0, i);  // move used integer to the front
            addInt(nums1, result, subResult, 1);
        }
        
        return result;
    }
    
    public void addInt(int[] nums, List<List<Integer>> result, List<Integer> subResult, int start) {
        if (start == nums.length) {
            result.add(subResult);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {  // generate index = start integer of list
            List<Integer> newSub = new ArrayList<>();
            newSub.addAll(subResult);
            newSub.add(nums[i]);
            int[] nums1 = new int[nums.length];
            System.arraycopy(nums, 0, nums1, 0, nums.length);
            swap(nums1, start, i);    // move used integer to the front
            addInt(nums1, result, newSub, start + 1);
        }
    }
    
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

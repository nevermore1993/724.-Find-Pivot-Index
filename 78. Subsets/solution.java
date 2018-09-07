// brute force, add subset into result everytime it adds a new element to the subset
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return new ArrayList(new ArrayList<Integer>());
        
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getResult(result, subset, 0, nums);
        
        return result;
        
    }
    
    public void getResult(List<List<Integer>> result, List<Integer> subset, int start, int[] nums) {
        result.add(subset);
        for (int i = start; i < nums.length; i++) {
            List<Integer> newSub = new ArrayList(subset);
            newSub.add(nums[i]);
            getResult(result, newSub, i + 1, nums);
        }       
    }
}

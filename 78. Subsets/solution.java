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


// 递归，与排列不同的是，每次添加新元素之后都能将temp加入到结果中。而且遍历过的元素不再需要了，所以每次递归时要将已经遍历过的元素去掉。
// 即System.arraycopy(nums, i+1, remain, 0, nums.length - i - 1);  如果不去掉，就会出现重复的组合。
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        res.add(new ArrayList<>(temp));
        
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            int[] remain = new int[nums.length - i - 1];
            System.arraycopy(nums, i+1, remain, 0, nums.length - i - 1);
            helper(res, temp, remain);
            temp.remove(temp.size() - 1);
        }
    }
}

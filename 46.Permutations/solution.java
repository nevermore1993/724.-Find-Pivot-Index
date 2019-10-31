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


// 对nums进行操作，每次操作一个数，将其不停右移，每移动一次就得到一个新的排列。然后对每个不同的数进行相同的操作。
// 这里的重点是每次递归调用之后要将之前做的操作还原，这里是元素的右移，通过左移还原。还原了之后才能对当前排列进行不同的操作。
// 假设我们已经对前n个数进行了操作，就当前这个排列来说，之后的元素还有很多种都是基于当前排列的，所以需要在操作后还原。
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> rsl  = new ArrayList<List<Integer>>();
        
        dfs(rsl, 0, nums);
        
        return rsl;
        
    }
    private static void dfs(List<List<Integer>> rsl, int left, int[] nums){
        
        if(left == nums.length){
            List<Integer> current = new ArrayList<Integer>();
            for(int x : nums){
                current.add(x);
            }
            rsl.add(current); 
        }
        else{
            for(int i = left;i<nums.length;i++){
                swap(nums,i,left);
                dfs(rsl, left+1, nums);
                swap(nums,i,left);
             }
        }        
        
    }
    
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}




// 类似上面，不过是添加和删除的操作和还原。
// 这里的permuteSub的意义就是当前已经排列好的是tmp，这个函数的结果就是基于tmp得到的所有排列。
// 在for循环里就是得到所有下一个可能的排列，然后递归调用，递归结束后自然要还原，才能得到不同的排列。
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        permuteSub(ret, new ArrayList<Integer>(), nums);
        return ret;
    }
    public void permuteSub(List<List<Integer>> ret, ArrayList<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!tmp.contains(nums[i])) {
                tmp.add(nums[i]);
                permuteSub(ret, tmp, nums);
                tmp.remove(tmp.size() -1);
            }
        }
    }
}


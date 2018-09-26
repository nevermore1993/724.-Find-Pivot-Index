// use set to store every element, if it already exist, remove. the last one remains is the answer
// beats 12% of all java submission
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                set.remove(nums[i]);
        }
        
        Iterator iterator = set.iterator();
        
        while (iterator.hasNext()){
            result = (int) iterator.next();  
      }
        return result; 
    }
}

// first sort, then find the answer
// beats 36% of all java submission
class Solution {
    public int singleNumber(int[] nums) {
        
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        int temp = 0, result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && temp == 0)
                return nums[i - 1];
            else if (nums[i] != nums[i - 1] && temp == 1)
                temp = 0;
            else
                temp = 1;
        }
        return nums[nums.length - 1]; 
    }
}

// Bit Manipulation
// 0 ^ 0 = 0; 0 ^ 1 = 1; 1 ^ 1 = 0, a ^ a ^ b = b
// beats 100% of all java submission
class Solution {
    public int singleNumber(int[] num) {
        int result = 0;
        for(int i =0;i<num.length;i++){
        
            result ^=num[i];
        }
        return result;
        
    }
}

// another solution, store all element in set to get rid of redundent element, x equals sum of all duplicate element, y 
// equals to single element  we can get the value of x + y  and  x + x + y, then calculate x to get y.

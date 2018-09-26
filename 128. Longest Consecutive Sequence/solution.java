//use hashmap to store every element. use containsKey() to find if there is consecutive number of current key. containsKey() has
//O(1) time complexity. set the value of each nood key to length, value of visited key to -1. every time we encounter a 
// non negetive value, it impies that we have found a subsequence, just add them together.
// key point here is to store length of a subsequence as key's value. because we dont do sort here, so we might start at the middle
// of a sequence.
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 0);
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == -1)
                continue;
            int length = 1;
            int key = e.getKey();
            while (map.containsKey(key + 1)) {
                if (map.get(key + 1) != 0) {
                    length += map.get(key + 1);
                    break;
                }  
                length++;
                key++;
                map.put(key, -1);
            }
            map.put(e.getKey(), length);
            max = Math.max(max, length);
        }
        return max;
    }
}

// sorted version, sort first, scan then.
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int max = 0;
    
        while ( i<nums.length){
            int localmax=1;

            while( i+1<nums.length && nums[i+1]-nums[i]==1 || i+1<nums.length && nums[i+1]== nums[i]){
                if(nums[i+1] != nums[i]) localmax++; 
                i++;
            }
            if (localmax>max) max=localmax;
            i++;
        }
        return max;
    }
}

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
                break;
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
            map.put(key, length);
            max = Math.max(max, length);
        }
        return max;
    }
}

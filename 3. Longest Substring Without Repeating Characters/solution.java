class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int maxLength = 0;
        int length = 0;
        int i = 0;
        int flag = 0;
        Map<Character, Integer> m = new HashMap<>();
        if (c.length == 0)
            return maxLength;
        else if (c.length == 1)
            return 1;
        while(i < c.length) {
            m.put(c[i], i);
            length = 1;
            for (int j = i + 1; j < c.length; j++) {
                if (!m.containsKey(c[j])) {
                    m.put(c[j], j);
                    length++;
                    flag = 1;
                }   
                else {
                    i = m.get(c[j]) + 1;
                    flag = 0;
                    break;
                }      
            }
            maxLength = (maxLength < length) ? length : maxLength;
            if (flag == 1)
                return maxLength;
            if (i == c.length - 1)
                return maxLength;
            m.clear();
        }

        return maxLength;
        
    }
}

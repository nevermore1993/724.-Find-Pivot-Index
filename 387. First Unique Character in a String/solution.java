// 两种方法，第一种遍历26个字母，找出在字符串中的位置，如果第一次出现的位置等于最后一次出现的位置，说明这个字母只出现了一次，则就是第一个
// 唯一的字母。
// 第二种方法，统计每个字母出现的次数，然后遍历，找出第一个只出现了一次的字母。如果只包含小写字母，则可以使用长度为26的数组来统计。
// 如果有其他的字符，则可以使用hashmap来统计，key为字符，value为次数。
class Solution {
    
     public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1; 
        }
        int index = Integer.MAX_VALUE;
        for(char c = 'a'; c <= 'z'; c++) {
           if (s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c)) {
               index = Math.min(index, s.indexOf(c));
           }
        }
        
        return index == Integer.MAX_VALUE ? -1 : index; 
    }

    public int firstUniqChar(String s) {
        int temp[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}

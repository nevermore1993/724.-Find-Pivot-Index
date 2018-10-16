// 两个数组，每一位对应一个字母的出现次数，比较
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cs = new int[26];
        int[] ct = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            ct[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ct[i])
                return false;
        }
        
        return true;
    }
}

// 一个数组，s中字母出现的时候给对应位加一，t中字母出现的时候给对应位减一，最后计算数组的和是不是0，much smarter
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s== null || t == null) {
            return false;
        }
        int [] arr = new int[26];
        for (char c:s.toCharArray()) {
            arr[c-'a']++;
        }
        for (char c:t.toCharArray()) {
            arr[c-'a']--;
        }
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i]);
        }
        return sum == 0?true:false;
    }
}

// 如果输入的字符串中不仅包含小写字母怎么办？排序，然后比较。或者用hashmap，hashmap的话也只用一个，然后最后判断hashmap.values()是否全
// 为0
class Solution {
    public boolean isAnagram(String s, String t) {
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}

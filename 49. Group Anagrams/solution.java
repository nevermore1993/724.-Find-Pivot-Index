// sort string, use sorted string as key, original string as a element of value list, store in map. 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        
        Map<String, List> map = new HashMap<String, List>();
        
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        
        return new ArrayList(map.values());
    }
}

// for each string, calculate appearence count of each letter, form a string, use it as key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        
        Map<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                str.append("#");
                str.append(count[i]);
            }
            String key = str.toString();
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        
        return new ArrayList(map.values());
    }
}

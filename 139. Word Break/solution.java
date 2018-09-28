// simple recursive solution, but Time Limit Exceeded
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0)
            return false;
        Set<String> set = new HashSet<>();
        Map<Character, List<String>> map = new HashMap<>();
        for (String string : wordDict)
            if (map.containsKey(string.charAt(0)))
                map.get(string.charAt(0)).add(string);
            else
                map.put(string.charAt(0), new ArrayList<String>() {{add(string);}});
        return helper(0, s, map);
    }
    
    public boolean helper(int start, String s, Map<Character, List<String>> map) {
        if (start == s.length())
            return true;
        else if (start > s.length())
            return false;
        char c = s.charAt(start);
        boolean result = false;
        if (map.containsKey(c)) {
            for (String string : map.get(c)) {
                if (result == true)
                    return result;
                if (start + string.length() <= s.length())
                    if (s.substring(start, start + string.length()).equals(string))
                        result |= helper(start + string.length(), s, map);
            }
                
        }
        
        return result;
    }
}

// simple dp solution, f[i] == true, means we can reach index i of s with exist string set. we decide its value by 
// f[j] && dict.contains(s.substring(j, i). finally return f[s.length()], means we can get whole string s with given string sets
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder("");
        char c;
        int i = 0;
        if (strs.length == 0)
            return "";
        
        while (i < strs[0].length()) {
            c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length() && strs[j].charAt(i) == c)
                    continue;
                else
                    return s.toString();  
            }
            s.append(String.valueOf(c));
            i++;
        } 
        return s.toString();
    }
}

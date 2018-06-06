public class Solution {
    public static List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
    
        if (digits.length()==0) 
            return result;
            
        result.add("");
        for (int i=0; i<digits.length(); i++) 
            result = combine(digitletter[digits.charAt(i)-'0'],result);
            
            return result;
        }
        
    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();
            
        for (int i=0; i<digit.length(); i++) 
            for (String x : l) 
                result.add(x+digit.charAt(i));
    
        return result;
    }
}

//简单的把数字可以组成的字符串组合出来，再把下一个数字代表的三个字母分别与已有的所有字符串组合就可以了。不要想的太复杂，树？可以，但
//太麻烦

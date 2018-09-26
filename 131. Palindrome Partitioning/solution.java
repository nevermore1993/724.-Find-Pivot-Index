// recursivly get all palindrome partition. 
// to optimize, pass index as parameter, not substring. and use same list to store temp result, construct a new one only when
// we need to add it to the final result.
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if (s.length() == 0)
            return result;
        
        helper(temp, s, result);
        
        return result;
    }
    
    public void helper(List<String> temp, String s, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                List<String> newTemp = new ArrayList<>(temp);
                newTemp.add(s.substring(0, i + 1));
                helper(newTemp, s.substring(i + 1), result);
            }   
        }
    }
    
    public boolean isPalindrome(String sub) {
        if (sub.length() == 1)
            return true;
        
        int i = 0;
        while (i < sub.length() / 2) {
            if (sub.charAt(i) == sub.charAt(sub.length() - i - 1))
                i++;
            else
                return false;
        }
        return true;
    }
}


// best solution from leetcode
class Solution {
    private List<List<String>> resultLst;
    private ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<>();
        currLst = new ArrayList<>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 && l>=s.length()){
            resultLst.add(new ArrayList<>(currLst));
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}

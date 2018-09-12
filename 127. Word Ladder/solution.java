// recursion, flags to store which element has been used. but exceed time limit
class Solution {
    int min = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] flag = new int[wordList.size()];
        if (!wordList.contains(endWord)) return 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                flag[i] = 1;
                break;
            }
        }
        
        helper(beginWord, endWord, wordList, flag, 1);
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
    
    public void helper(String beginWord, String endWord, List<String> wordList, int[] flag, int step) {
        if (oneCharDiff(beginWord, endWord)) {
            min = Math.min(step + 1, min);
            return;
        }
        
        if (step >= flag.length)
            return;
        
        for (int i = 0; i < wordList.size(); i++) {
            if (oneCharDiff(wordList.get(i), endWord) && flag[i] != 1) {
                int[] flag1 = new int[flag.length];
                System.arraycopy(flag, 0, flag1, 0, flag.length);
                flag1[i] = 1;
                if ((step + 1) < min)
                    helper(beginWord, wordList.get(i), wordList, flag1, step + 1);
            }
        }
        return;
    }
    
    public boolean oneCharDiff(String original, String target) {
        int n = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != target.charAt(i))
                n++;
        }
        if (n == 1)
            return true;
        else 
            return false;
    }
}

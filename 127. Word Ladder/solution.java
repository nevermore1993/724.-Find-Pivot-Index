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


// accepted solution, use set to replace list. set.contains() is way faster than list.contains().
// when length = 1, begin set store all words than can be reached within one step, when length = 2, it stores all words than
// can be reached within one step from previous beginset.
// swap begin set and end set if begin.size() > end.size()  to reduce time complexity
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String s : wordList)
            words.add(s);
        
        return helper(beginWord, endWord, words);
    }
    
    public int helper(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        if (!wordList.contains(endWord))
            return 0;
        int len = 1;
	    int strLen = beginWord.length();
	    HashSet<String> visited = new HashSet<String>();
	
	    beginSet.add(beginWord);
	    endSet.add(endWord);
	
	    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
		    if (beginSet.size() > endSet.size()) {
		    	Set<String> set = beginSet;
		    	beginSet = endSet;
		    	endSet = set;
		    }

		    Set<String> temp = new HashSet<String>();
		    for (String word : beginSet) {
			    char[] chs = word.toCharArray();

			    for (int i = 0; i < chs.length; i++) {
				    for (char c = 'a'; c <= 'z'; c++) {
					    char old = chs[i];
					    chs[i] = c;
					    String target = String.valueOf(chs);

					    if (endSet.contains(target)) {
						    return len + 1;
				    	}

					    if (!visited.contains(target) && wordList.contains(target)) {
						    temp.add(target);
						    visited.add(target);
				    	}
					    chs[i] = old;
				    }
			    }
		    }

		    beginSet = temp;
		    len++;
    	}
	
	    return 0;
    }
}

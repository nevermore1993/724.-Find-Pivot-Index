// my solution with recursion, add '(' or ')' in each recursion
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder("");
		generate(s, 0, 1, n * 2);
		generate(s, 1, 1, n * 2);
        return result;
    }
    
	public void generate(StringBuilder s, int type, int current, int n) {
		StringBuilder ns = new StringBuilder(s);
		if (type == 0) {
			ns.append("(");
		} else {
			ns.append(")");
		}
		if ((current - getBracketNumber(ns)) > getBracketNumber(ns)) {
			return;
		} else if (getBracketNumber(ns) > n / 2){
			return;
		} else if (current != n){
			generate(ns, 0, current + 1, n);
			generate(ns, 1, current + 1, n);
		} else {
			result.add(ns.toString());
		}
	}
	
	public int getBracketNumber(StringBuilder s) {
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				j++;
		}
		return j;
	}
}


// 记录当前string中的左右括号的数量，如果左大于右，则可以加一个右括号，如果左括号小于n个，则一定可以加一个左括号。
// 每次添加操作后递归，递归结束后要进行还原操作，使的当前的string模板可以有不同的后续组合。
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new String(), 0, 0, n);
        return res;
    }
    public void helper(List<String> res, String temp, int left, int right, int n) {
        if (left + right == n * 2) {
            res.add(temp);
            return;
        }

        if (left > right) {
            temp += ')';
            helper(res, temp, left, right+1, n);
            temp = temp.substring(0, temp.length()-1);
        }
        if (left < n) {
            temp += '(';
            helper(res, temp, left+1, right, n);
            temp = temp.substring(0, temp.length()-1);
        }
        
    }
}

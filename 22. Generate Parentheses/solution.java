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

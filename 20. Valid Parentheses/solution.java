//必有一个（） {} 或 【】，replace one of them with "" on each iteration, if string is empty in the end, vaild, otherwise, invaild.

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        int l = s.length();
        /*String s1 = new String("()");
        String s2 = new String("{}");
        String s3 = new String("[]");*/
        
        
        while (!s.isEmpty()) {
            if (s.indexOf("()") >= 0) {
                //System.out.println(s.indexOf("()") + " " + i);
                s = s.replace("()", "");
            }    
            else if (s.indexOf("{}") >= 0) {
                //System.out.println(s.indexOf("{}") + " " + i);
                s = s.replace("{}", "");
            }  
            else if (s.indexOf("[]") >= 0) {
                //System.out.println(s.indexOf("[]") + " " + i);
                s = s.replace("[]", "");
            }  
            else
                return false;
        }

        return true;
    }
}

//when char == ( { or [, push ) } ] into stack. when char != ( { [, pop stack, if != ) } ], invaild. because the first { ( [ must close a ( { [
next to it.
//因为} 】 ） 出现时必定关闭的是最后出现的一个 （ 【 {， 所以将已经出现的 （ { 【对应的 ） } 】压入栈，每次pop比较，如果符合，valid，否则，invalid；

class Solution {
  public boolean isValid(String s) {
	  Stack<Character> stack = new Stack<Character>();
	  for (char c : s.toCharArray()) {
		  if (c == '(')
			  stack.push(')');
		  else if (c == '{')
			  stack.push('}');
		  else if (c == '[')
			  stack.push(']');
		  else if (stack.isEmpty() || stack.pop() != c)
			  return false;
	  }
	  return stack.isEmpty();
    }
}

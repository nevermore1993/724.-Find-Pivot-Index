// my stupid solution, calculate temp value, form a new String array, recursivly get the result
class Solution {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return Integer.parseInt(tokens[0]);
        if (length == 3)
            return getTemp(tokens[0], tokens[1], tokens[2]);
        
        int temp = 0, index = 0;
        for (int i = 0; i < length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                index = i;
                temp = getTemp(tokens[i - 2], tokens[i - 1], tokens[i]);
                break;
            }
        }
        
        String[] sub = new String[length - 2];
        System.arraycopy(tokens, 0, sub, 0, index - 2);
        sub[index - 2] = String.valueOf(temp);
        System.arraycopy(tokens, index + 1, sub, index - 1, length - index - 1);
        return evalRPN(sub);
    }
    
    public int getTemp(String op1, String op2, String op) {
        if (op.equals("+"))
            return Integer.parseInt(op1) + Integer.parseInt(op2);
        else if (op.equals("-"))
            return Integer.parseInt(op1) - Integer.parseInt(op2);
        else if (op.equals("*"))
            return Integer.parseInt(op1) * Integer.parseInt(op2);
        else if (op.equals("/"))
            return Integer.parseInt(op1) / Integer.parseInt(op2);
            
        return 0;
    }
}


// using stack like array, push element into stack array, every time encounter a operator, calculate its value, replace 
// original value, and proceed push.
class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int i = -1;
        for (String tk : tokens) {
            if (tk.equals("+")) {
                int a = stack[i--];
                int b = stack[i--];
                stack[++i] = a + b;
            } else if (tk.equals("-")) {
                int a = stack[i--];
                int b = stack[i--];
                stack[++i] = b - a;
            } else if (tk.equals("*")) {
                int a = stack[i--];
                int b = stack[i--];
                stack[++i] = b * a;
            } else if (tk.equals("/")) {
                int a = stack[i--];
                int b = stack[i--];
                stack[++i] = b / a;
            } else {
                stack[++i] = Integer.parseInt(tk);
            }
        }
        return stack[0];  
        /*
        
        int[] stack = new int[tokens.length];
        int i = -1;
        for (String tk : tokens) {
            if (tk.equals("+"))
                stack[i - 1] += stack[i--];
            else if (tk.equals("-"))
                stack[i - 1] -= stack[i--];
            else if (tk.equals("*"))
                stack[i - 1] *= stack[i--];
            else if (tk.equals("/"))
                stack[i - 1] /= stack[i--];
            else
                stack[++i] = Integer.parseInt(tk);
        }
        return stack[0];
        */
    }
}

// best accepted java solution, method eval() , if last element of ss is operand, return its value, otherwise get into recursion
// of substring to get result, global variable i is the index of last index of substring
class Solution {
    int i;
    public int evalRPN(String[] tokens) {
        i = tokens.length - 1;
        return eval(tokens);
    }
    
    int eval(String[] ss) {
        String s = ss[i--];
        switch (s) {
            case "+":
                return eval(ss) + eval(ss);                
            case "-":
                return - eval(ss) + eval(ss);
            case "*":
                return eval(ss) * eval(ss);
            case "/":
                return (int) (1.0 / eval(ss) * eval(ss));
            default:
                return Integer.valueOf(s);
        }
    }
}

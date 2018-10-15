// 利用栈。先假设第一个操作符是+，取出第一个数字，根据操作符，+的话就将数字压入栈，-的话就压入数字的相反数，*或/的话就
// 压入当前数和栈顶数的计算结果（因为乘除的优先级高，需要先计算出结果），然后取出下一个操作符，更新操作符。直至整个string都遍历结束，栈里剩下的
// 都是需要相加的数字，乘除的结果已经在入栈的时候就计算出来了。

// 我想到的方法是将String按照数字和运算符分为List<String>，然后先计算乘除，用结果c替代a*b，继续遍历。乘除处理完后再处理加减。
// 基本思想都是先计算出乘除的局部结果。
class Solution {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
}

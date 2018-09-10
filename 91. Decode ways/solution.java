// dynamic programming

// tmp >= 10 && tmp >= 26 ***
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        if(s.charAt(0)=='0') return 0;
        dp[1]=1;
        for (int i =2; i<s.length()+1; i++){
            if (s.charAt(i-1)!='0') dp[i]=dp[i-1];
            int tmp=(s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if(tmp >=10 && tmp <= 26) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}

//array dp is used to describe "# of digits in string"
//    dp[0] dp[1] dp[2] dp[3] ... dp[n] 
//           s[0]  s[1]  s[2] ... s[n-1] 


// my dp solution, lots of if-else statement to deal with corner case, so fcking stupid
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int dp[] = new int[s.length()];
        
        
        dp[0] = 1;
        if (s.charAt(0) - '0' == 0)
            return 0;
        if (s.length() == 1)
            return dp[0];
        
        if (s.charAt(1) - '0' == 0) {
            if (s.charAt(0) - '0' <= 2 && s.charAt(0) - '0' > 0)
                dp[1] = 1;
            else 
                return 0;
        } else {
            if (s.charAt(0) - '0' == 2 && s.charAt(1) - '0' <= 6 || s.charAt(0) - '0' == 1)
                dp[1] = 2;
            else 
                dp[1] = 1;
        }
        
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) - '0' == 0) {
                if (s.charAt(i - 1) - '0' <= 2 && s.charAt(i - 1) - '0' > 0)
                    dp[i] = dp[i - 2];
                else
                    return 0;
            } else {
                if (s.charAt(i - 1) - '0' == 2 && s.charAt(i) - '0' <= 6 || s.charAt(i - 1) - '0' == 1 )
                    dp[i] = dp[i - 1] + dp[i - 2];
                else 
                    dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}

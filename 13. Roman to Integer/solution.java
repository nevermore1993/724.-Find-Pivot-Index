class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        char c;
        int spe = 0;
        int result = 0;
        for(int i = 0; i < length; i++) {
            c = s.charAt(i);
            if(c == 'I' || c == 'X' || c == 'C') {
                spe = speCheck(s, i);
            }
            
            if(spe != 0) {
                result = result + spe;
                i++;
                spe = 0;
            } else {
                result = result + norNum(s, i);
            }
        }
        return result;
    }
    
    public int speCheck(String s, int i) {
        switch (s.charAt(i)) {
            case 'I' :
                if(i + 1 < s.length() && s.charAt(i + 1) == 'V')
                    return 4;
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'X')
                    return 9;
                else 
                    return 0;
            case 'X' :
                if(i + 1 < s.length() && s.charAt(i + 1) == 'L')
                    return 40;
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'C')
                    return 90;
                else 
                    return 0;
            case 'C' :
                if(i + 1 < s.length() && s.charAt(i + 1) == 'D')
                    return 400;
                else if(i + 1 < s.length() && s.charAt(i + 1) == 'M')
                    return 900;
                else 
                    return 0;
            default:
                return 0;
        }
    }
    public int norNum(String s, int i) {
        switch (s.charAt(i)) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

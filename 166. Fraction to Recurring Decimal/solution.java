// 模拟除法的计算过程 1.记录每一次的余数，如果出现与之前相同的余数，说明会循环，计算index差，就能知道循环的位数
//2.将除数被除数转换为绝对值和long类型，以应对负数及Integer.MIN_VALUE的情况
//3.什么时候加小数点？如果整数部分整除了，map中会存一个key为0，value也为0的值，需要去掉最后的小数点
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> seedMap = new HashMap<>();
        int repeatCount = 0;
        boolean isNege = false;
        int time = 0;
        if ((numerator > 0) ^ (denominator > 0))
            isNege = true;
        long numerator1 = Math.abs((long) numerator);
        long denominator1 = Math.abs((long) denominator);
        
        if (numerator1 == 0)
            return "0";
        while(numerator1 != 0) {
            if (numerator1 < denominator1) {
                result.append("0");
                
                if (time == 0)
                    result = result.insert(1, ".");
                seedMap.put(numerator1, repeatCount);
                numerator1 *= 10;
                repeatCount++;
                time++;
            } else {
                long next = numerator1 % denominator1;
                if (seedMap.containsKey(next)) {
                    result.append(String.valueOf(numerator1 / denominator1));
                    result = result.insert(result.length() - (repeatCount - seedMap.get(next)), "(");
                    result = result.insert(result.length(), ")");
                    break;
                } else {
                    result.append(String.valueOf(numerator1 / denominator1));
                    if (time == 0)
                        result = result.insert(result.length(), ".");
                    numerator1 = next * 10;
                    time++;
                }
                seedMap.put(next, repeatCount);
                repeatCount++;
            }
        }
        if (seedMap.containsKey((long)0)) {
            if (seedMap.get((long)0) == 0)
                return isNege ? "-" + result.toString().substring(0, result.length() - 1) : result.toString().substring(0, result.length() - 1);
        }
            
        return isNege ? "-" + result.toString() : result.toString();
        
    }
}

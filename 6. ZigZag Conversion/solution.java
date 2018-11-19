// 寻找规律，第一层循环遍历每一层，第二层循环遍历每一个锯齿。
class Solution {
    public String convert(String s, int numRows) {
        if (s.isEmpty() || numRows < 2)
            return s;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + 2 * numRows - 2) {
                result.append(String.valueOf(s.charAt(j)));
                int index = j + 2 * numRows - 2 - 2 * i;
                if (index >= s.length() || index == j || i == 0)
                    continue;
                else
                    result.append(String.valueOf(s.charAt(index)));
            }
        }
        return result.toString();
    }
}

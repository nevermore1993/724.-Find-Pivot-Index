// fill in the tree layer by layer
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= i - 1; j++) {
                temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i > 0)
                temp.add(1);
            result.add(temp);
        }
        return result;
    }
}

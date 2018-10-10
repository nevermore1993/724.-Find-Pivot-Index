// sort string
class Solution {
    public String largestNumber(int[] nums) {
       String[] strs = new String[nums.length];
       for(int i=0;i<nums.length;++i){
           strs[i] = Integer.toString(nums[i]);
       }
        // we want to sort such that number is maximized 
        // if a length of two string are equal than the larger number comes before the smaller
       Arrays.sort(strs,new Comparator<String>(){
           public int compare(String a, String b ){
               if( a.length() == b.length() )
                 return b.compareTo(a);
                String x = a + b;
                String y = b + a;
                return y.compareTo(x); 
           }
       }); 
        StringBuilder sb = new StringBuilder();
        for( String s : strs)
            sb.append(s);
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}


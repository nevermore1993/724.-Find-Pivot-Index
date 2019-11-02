// 统计A，B,C,D中每个元素出现的个数。统计A,B中所有可能和的出现次数。在C,D的可能和中找是否符合A,B的可能和的个数。
// 将原本的四重嵌套循环变为两个两层嵌套。
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> A_m = new HashMap<>();
        HashMap<Integer, Integer> B_m = new HashMap<>();
        HashMap<Integer, Integer> C_m = new HashMap<>();
        HashMap<Integer, Integer> D_m = new HashMap<>();
        HashMap<Integer, Integer> AB_m = new HashMap<>();
        int res = 0;
        for (int i : A) A_m.put(i, A_m.getOrDefault(i, 0) + 1);
        for (int i : B) B_m.put(i, B_m.getOrDefault(i, 0) + 1);
        for (int i : C) C_m.put(i, C_m.getOrDefault(i, 0) + 1);
        for (int i : D) D_m.put(i, D_m.getOrDefault(i, 0) + 1);
        
        for (Integer ka : A_m.keySet()) {
            for (Integer kb : B_m.keySet()) {
                AB_m.put(ka + kb, AB_m.getOrDefault(ka+kb, 0) + A_m.get(ka) * B_m.get(kb));
            }
        }
        for (Integer kc : C_m.keySet()) {
            for (Integer kd : D_m.keySet()) {
                if (AB_m.getOrDefault(-(kc+kd), 0) != 0) {
                    res += AB_m.get(-(kc+kd)) * C_m.get(kc) * D_m.get(kd);
                }
                    
            }
        }
        return res;
    }
}





// 同样的方法，不过省去了统计A,B,C,D的元素个数的步骤。
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> mapAB = new HashMap<>(500_000);
        int count = 0;
        for(int a: A){
            for(int b : B){
                int sum = a+b;
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int c : C){
            for(int d : D){
                count += mapAB.getOrDefault(-c-d, 0);
            }
        }
        
        return count;
        
    }
}

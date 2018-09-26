// first check if there is such a start exist. then find its position.
// once we verified there must be an answer, we can get the result in one iteration,
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int tank = 0;
    for(int i = 0; i < gas.length; i++)
        tank += gas[i] - cost[i];
    if(tank < 0)
        return - 1;
        
    int start = 0;
    int accumulate = 0;
    for(int i = 0; i < gas.length; i++){
        int curGain = gas[i] - cost[i];
        if(accumulate + curGain < 0){
            start = i + 1;
            accumulate = 0;
        }
        else accumulate += curGain;
    }
    
    return start;
    }
}

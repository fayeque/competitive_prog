//steps:
//1.Simply we have to loop through each element and calculate total if total is lestt then 0 break;
//2.Stopcount is used to check if we react to n numbers or not

//O(n^2) approach

//code

class Solution1{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<gas.length;i++){
            int total=0;int stopCount = 0 ; int j=i;
            while(stopCount < n){
                total+=gas[j%n] - cost[j%n];
                if(total<0){
                    break;
                }
                stopCount++;
                j++;
            }
            if(stopCount==n && total>=0){
                return i;

            }
        }
        return -1;
    }
}

//O(n) approach
//1.we have to loop through the gas array and calculate the total.
//2.if total is less than 0 means till that point there will be no any possible index.
//3.So we update the index with the next one and make tank=0;
//4.From those 3 points we will be able to find that index which can be a possible solution but we are not sure about it.
//5.Most important step is to calculate the total which should be greater then 0 to meet the required condition.


//code
class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;int total=0;int index=0;
        for(int i=0;i<gas.length;i++){
            int capacity=gas[i]-cost[i];
            tank += capacity;
            if(tank<0){
                index=i+1;
                tank=0;
            }
            total+=capacity;
        }
        return total >= 0 ? index : -1;
    }
}
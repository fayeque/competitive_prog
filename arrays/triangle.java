import java.util.Arrays;
import java.util.List;

//leetcode 120
//steps
//1.We have to use dp concept to solve the problem
//2.We will define an array of size triangle length + 1
//3.We will simply calculate min of dp[j] and dp[j+1] for a particular element at j and add it with dp[j]
//4. This will serve as the to find min element for the upper elements.

//code 

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size() + 1];
        Arrays.fill(dp,0);
        for(int i=triangle.size() - 1; i>= 0 ; i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
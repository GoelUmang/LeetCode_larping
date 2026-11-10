class Solution {
    public int climbStairs(int n, int[] costs) {
        //classic dp problem
        // rolling window: dp[j-3], dp[j-2], dp[j-1]
        //costs[j] + (j - i)^2
        int backThree = 0; //dp[0]
        int backTwo = (backThree + 1) + costs[0];//dp[1]
        if(n == 1) return backTwo;
        
        //
        int backOne = Math.min(backTwo + 1, backThree + 4) + costs[1];//dp[2]

        if (n == 2) return backOne;       
        int curr = 0;
        for(int i = 3 ; i <= n ; i++){
            curr = Math.min(Math.min(backOne + 1, backTwo + 4), backThree + 9) + costs[i - 1];
            backThree = backTwo;
            backTwo = backOne;
            backOne = curr;
        }
        return curr;
    }
}
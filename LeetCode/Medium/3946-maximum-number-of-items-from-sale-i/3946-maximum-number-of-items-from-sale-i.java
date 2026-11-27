class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        //pick greadily based on the loweest price
        //and tak 1 for each we can take
        // and then compute the free copy
        //then for whatever budget is left we use again the lowest
        //0/1 Knapsack + greedy.

        //precomputing 

        int n = items.length;
        int[] reward = new int[n];

        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n ; i++){
            minPrice = Math.min(minPrice, items[i][1]);

            reward[i] = 1;//base case

            for(int j = 0; j < n; j++){
                if(j != i && items[j][0] % items[i][0] == 0 ){
                    reward[i]++;
                }
            }
        }

        //for each item, 
        ///skip dp[] unchanged
        // take spedn the price and add its reward
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < n ; i++){
            int price = items[i][1];

            for(int b = budget ; b >= price; b--){
                if(dp[b-price] != -1){
                    dp[b] = Math.max(dp[b], dp[b-price] + reward[i]);
                }
            }
        }
        int ans = 0;

        for(int b = 0; b <= budget; b++){
            if(dp[b] != -1){
                ans = Math.max(ans, dp[b] + (budget - b) / minPrice);
            }
        }
        return ans;

        
    }
}
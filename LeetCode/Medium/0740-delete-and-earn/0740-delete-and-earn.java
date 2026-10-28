class Solution {
    public int deleteAndEarn(int[] nums) {
        //count all the number and thier total value ie // for 223 its 2 : 4 and 3 : 3
        Map<Integer, Integer> hash = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        //dp array
        int[] dp = new int[maxNum + 1];
        
        //base case :
        // dp[0] = 0;//0 time something 0
        // dp[1] = hash.getOrDefault(1, 0);

        //more optimised
        int oneback = hash.getOrDefault(1, 0);
        int twoback = 0;
        

        for(int i = 2; i <= maxNum ; i++){
            int earn = hash.getOrDefault(i, 0);
            //dp[i] = Math.max(dp[i-1] , dp[i-2] + earn);
            int temp = oneback;
            oneback = Math.max(oneback, earn + twoback);
            twoback = temp;

        }
        return oneback;
    }
}
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        //for every elemnt search another loop for another windw
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int currSum = 0;
            for(int j = i; j < n ; j++){
                currSum += nums.get(j);
                int length = j - i + 1;
                //whose sum is greater than 0(bruh)
                if(length >= l && length <= r && currSum > 0){
                    ans = Math.min(ans, currSum);
                }
            }
        }
        return(ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
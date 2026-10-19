class Solution {
    //Map<Integer, Integer> hash = new HashMap<>();

    public int rob(int[] nums) {
        //bootom up approach idea
        int[] dp = new int[nums.length + 1];
        
        //base Case : if ther is only one element thus the largest
        if(nums.length == 1) return nums[0];

        int previousPrevious = nums[0];
        int previous = Math.max(nums[0], nums[1]);
        
        //basic idea is to get to max money, either 
        //i take the( 1 3 6 ) 1 and 6 ie the curr and the prvPrv
        //or in thi case (1 9 6) i take the prv;
        // so at each house i check which one is max to deteermine the max profit

        for(int i = 2 ; i < nums.length ;i++){
            int house = nums[i];
            int temp = previous;
            previous = Math.max(previous, house + previousPrevious);
            previousPrevious = temp;
        }
        return previous;

        //topdown approach
        //dp
    //     return dp(nums,nums.length-1);
    
    // public int dp(int[] nums , int n){
    //     //base case if we have one element
    //     if(n == 1) return Math.max(nums[0], nums[1]);

    //     //base case if we have only two elementa we return max
    //     if(n == 0) return nums[0];

    //     //dp startes here
    //     //if our hashmap have the info about the money
    //     if(hash.containsKey(n)){
    //         return hash.get(n);//retrun the money
    //     }

    //     hash.put(n, Math.max(
    //         dp(nums,n-1), dp(nums,n-2) + nums[n]
    //     ));
    //     return hash.get(n);
    }
}
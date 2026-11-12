class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = nums.length;
        int maxInc = 1, maxDec = 1;
        int inc = 1, dec = 1;
        for(int i = 1 ; i < len ; i++){
            //if inc, ++ the inc one 
            if(nums[i] > nums[i-1]){
                inc++;
                dec = 1;
            }
            if(nums[i] < nums[i - 1]){
                dec++;
                inc = 1;
            }
            if(nums[i] == nums[i-1]){
                inc = 1;
                dec = 1;
            }
            maxInc = Math.max(inc, maxInc);
            maxDec = Math.max(dec, maxDec);
        }
        return (maxDec > maxInc) ? maxDec : maxInc; 
    }
}
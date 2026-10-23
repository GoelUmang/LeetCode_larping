class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length; 
        //take the and of all the elements not in order 
        int aand  = -1;

        for(int i = 0; i < n ; i++){
            if(nums[i] != i){
                aand = aand & nums[i];

            }
        }
        return(aand == -1)? 0 : aand;
    }
}
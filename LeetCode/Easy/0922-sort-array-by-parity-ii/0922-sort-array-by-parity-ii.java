class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //even length
        //put even number in even idx
        //put odd number in odd indx

        int even = 0;
        int odd = 1;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length ; i++){
            //num is odd
            if(nums[i] % 2 != 0){
                ans[odd] = nums[i];
                odd += 2;
            }else{ 
                ans[even] = nums[i];
                even += 2;
            }

        }  
        return ans;
    }    
}
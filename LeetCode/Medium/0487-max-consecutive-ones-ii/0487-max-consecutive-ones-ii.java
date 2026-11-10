class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        //sliding window question
        int left = 0, right = 0;
        int zeroIdx = -1;
        int max = 0;


        //follow up
        while(right < n){
            if(nums[right] == 0){
                //store the max
                max = Math.max(max, right - left);
                left = zeroIdx + 1;// last zero idx + 1 for curr window
                zeroIdx = right;//cur 0 idx
            }
            right++;
        }
        max = Math.max(max, right - left);
        return max;


        // for(int right = 0; right < n; right++){
        //     //remove if the count > 0 and right is 0
        //     while(nums[right] == 0 && count != 0){
        //         if(nums[left] == 0){
        //             count = 0;//reset
        //         }
        //         left++;
        //         max--;
        //     }
        //     //add the first 0
        //     if(nums[right] == 0 && count == 0){
        //         count++;
        //     }
        //     //1
        //     max++;
        //     ans = Math.max(max, ans);
        // }
        // return ans;
    }
}
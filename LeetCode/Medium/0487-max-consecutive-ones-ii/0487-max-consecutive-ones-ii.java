class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        //sliding window question
        int left = 0 ;
        int count = 0;
        int max = 0;
        int ans = 0;

        for(int right = 0; right < n; right++){
            //remove if the count > 0 and right is 0
            while(nums[right] == 0 && count != 0){
                if(nums[left] == 0){
                    count = 0;//reset
                }
                left++;
                max--;
            }

            //add the first 0
            if(nums[right] == 0 && count == 0){
                count++;
            }
            //1
            max++;

            ans = Math.max(max, ans);
        }
        return ans;
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        
        int start = 0;
        int end = n - 1;
        int curr = 0;

        while(curr <= end){
            // if start has 2 swap with end
            // if end has 0 swap with start
            // if either gets one, wait until other gets the 2 or 0
            //now start might have 1 or 2 and end might have 1 or 0
            if(nums[curr] == 2){
                //swap with end
                int tmp = nums[curr];
                nums[curr] = nums[end];
                nums[end--] = tmp;
            }
            else if(nums[curr] == 0){
                //swap with start
                int tmp = nums[start];
                nums[start++] = nums[curr];
                nums[curr++] = tmp;
            }else curr++;//if 1;
        }
    }
}
class Solution {
    public int largestPerimeter(int[] nums) {
        //area is 1/2 B h
        //for max is sort and last last sec and first
        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= 2 ; i--){
            if(nums[i] < nums[i-2] + nums[i-1]){
                return (nums[i] + nums[i-2] + nums[i-1]);
            }
        }
        return 0;
    }
}
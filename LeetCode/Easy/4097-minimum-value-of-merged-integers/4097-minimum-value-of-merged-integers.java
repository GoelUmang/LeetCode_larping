class Solution {
    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < nums.length ; i+=2){
            String prev = Integer.toString(nums[i-1]);
            String curr = Integer.toString(nums[i]);
            String number = prev + curr;

            min = Math.min(min, Integer.parseInt(number));
        }
        return min;
    }
}
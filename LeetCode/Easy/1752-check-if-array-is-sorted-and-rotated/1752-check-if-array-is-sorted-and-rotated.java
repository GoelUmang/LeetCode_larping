class Solution {
    public boolean check(int[] nums) {
        //if array is rotated we sotre the first element 
        int num = nums[0];
        int i = 1;
        while(i < nums.length && nums[i-1] <= nums[i]){
            i++;
        }
        if(i == nums.length) return true;

        //now i points at the point
        while(i < nums.length - 1 && nums[i] <= nums[i+1] 
        && nums[i+1] <= num){
            i++;
        }
        return (i == nums.length - 1 && nums[i] <= num);
    }
}
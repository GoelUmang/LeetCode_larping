class Solution {
    public int minMoves2(int[] nums) {
        //sort the arr
        //then find the median element
        // which ever element is closer to median
        //then the diff btw the 
        //1 10 2 9 
        // 1 2 9 10
        // 2 2 9 10
        // 2 2 9 9
        // 2 (3 4 5 6 7 8 9) 9 9 
        // median is (9 + 2) / 2 = 5.5 is closer to 2
        // 2 2 9 10
        // 2 2 8 10
        // 2 2 7 10
        // 2 2 (6 5 4 3 2)(9 8 7 6 5 4 3 2) 16 moves leso
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];
        // if(n % 2 == 0){
        //     median = (nums[n / 2] - 1 + nums[n / 2]) / 2;   // = (2x - 1) / 2 = x - 1
        // }
        

        int moves = 0;
        for(int num : nums ){
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
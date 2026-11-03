class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        //or treat everything to max as a histogram
        //in the end we want all to be same 
        // area = l * h ( l is the len of the array )
        // h is the max

        int area = 0;
        for(int num : nums){
            area += num;
            max = Math.max(max, num);
        }

        return (nums.length * max ) - area;
        // for(int num : nums) max = Math.max(max, num);
        
        // int moves = 0;
        // for(int num : nums) moves += Math.abs(max - num);
        // return moves;
    }
}
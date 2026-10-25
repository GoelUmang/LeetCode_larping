class Solution {
    public int sumOfUnique(int[] nums) {
        //return only the sum of unique elements 
        //contraints to be asked is 
        // value of sum(can it be overfowed)
        //size of n 
        // any io bound contraints?
        //is it live stream or not 
        int[] freq = new int[101];
        
        int sum = 0;
        for(int num : nums){
            freq[num]++;
        }
        for(int num : nums){
            if(freq[num] == 1) sum+=num;
        }
        return sum;
    }
}
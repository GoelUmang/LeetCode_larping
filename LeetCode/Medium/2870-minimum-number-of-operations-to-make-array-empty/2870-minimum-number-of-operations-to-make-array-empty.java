class Solution {
    public int minOperations(int[] nums) {
        //we can remove 2 of same elements or
        // we can remove 3 of all elements
        
        //store the freq and then check
        //for each freq pair, reduce it 

        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for(int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        for(int freq : hashMap.values()){
            if(freq == 1) return -1;
            // if % 3 == 0 divides fully
            else if( freq % 3 == 0) count += freq / 3;

            // if % 3 == 1  divides means for 4 (4%3 == 1) instead use 2 2's so 
            // freq / 3 (take this as 2) and addiitonal 2
            else if( freq % 3 == 1) count += freq / 3 + 1;
            // similar for this for 5 one two and one tree
            else count += freq / 3 + 1;

        }
        return count;
    }
}
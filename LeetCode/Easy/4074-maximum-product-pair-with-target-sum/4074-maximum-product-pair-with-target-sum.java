class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int maxProduct = Integer.MIN_VALUE;
        int[] ans = new int[]{-1,-1};
        Map<Integer, Integer> hash = new HashMap<>();
        //store the num and index
        //iterate vo
        int i = 0;
        for(int num : nums){
            hash.put(num, i++);
        }
        //iterate if num has a target pair
        i = 0;
        for(int num : nums){
            if(num > (target - num) && hash.containsKey(target - num)){
                if( i != hash.get(target- num)){
                    int product = num * (target - num);
                    if(product > maxProduct){
                        maxProduct = product;
                        ans[0]= i;
                        ans[1] = hash.get(target-num);
                    }
                }
            }
            i++;
        }
        return ans;
    }
}
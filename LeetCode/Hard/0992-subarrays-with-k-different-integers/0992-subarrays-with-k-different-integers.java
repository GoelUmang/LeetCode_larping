class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }
    public int atmost(int[] nums, int k){
        Map<Integer, Integer> hash = new HashMap<>();
        int left = 0;

        int ans = 0;

        for(int right = 0; right < nums.length; right++){
            //add to the window and the hashmap
            hash.put(nums[right], hash.getOrDefault(nums[right], 0) + 1);

            //remove until only k diff no left
            while(left <= right && hash.size() > k){
                hash.put(nums[left], hash.get(nums[left]) - 1);
                if(hash.get(nums[left]) == 0) hash.remove(nums[left]);
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
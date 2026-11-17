class Solution {
    public int totalFruit(int[] fruits) {
        //sliding window approach
        int left = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        int ans = 0;
        for(int right = 0; right < fruits.length; right++){
            //add to the window
            hash.put(fruits[right], hash.getOrDefault(fruits[right], 0 )+1 );
            while(left < right && hash.size() > 2){
                hash.put(fruits[left], hash.get(fruits[left])-1);
                //if the freq of left is 0 remove
                if(hash.get(fruits[left]) == 0) hash.remove(fruits[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
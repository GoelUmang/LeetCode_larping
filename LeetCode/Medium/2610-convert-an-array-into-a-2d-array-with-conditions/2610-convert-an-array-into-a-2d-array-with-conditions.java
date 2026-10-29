class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[201];
        int max = 0;
        for(int num : nums){
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        List<List<Integer>> result = new ArrayList<>();
        //now 
        while(max > 0){
            List<Integer> subArr = new ArrayList<>();
            for(int i = 1; i < freq.length ; i++){
                if(freq[i] > 0){
                    subArr.add(i);
                    freq[i]--;
                }
            }
            max--;
            result.add(subArr);
        }
        return result;
    }
}
class Solution {
    public int minimumRecolors(String blocks, int k) {
       //sliding window questions
       //count the no of B in the window
       //store the min(k - b,ans);
        int minWindow = Integer.MAX_VALUE;
        int left = 0;
        int len = blocks.length();
        int blackCount = 0;
       
        for(int right = 0; right < len ; right++){
            char c = blocks.charAt(right);
            blackCount += (c == 'B') ? 1 : 0;

            if(right - left + 1 > k){
                blackCount -= (blocks.charAt(left) == 'B') ? 1 : 0;
                left++;
            }
            minWindow = Math.min(minWindow, k - blackCount);
        }
        return minWindow;
    }
}
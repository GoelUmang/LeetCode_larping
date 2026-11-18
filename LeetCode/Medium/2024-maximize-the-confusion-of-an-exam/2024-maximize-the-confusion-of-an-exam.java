class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //k is the swaps
        int left = 0; 
        int ans = 0;
        int t = 0, f = 0;
        for(int right = 0; right < answerKey.length(); right++){
            char c = answerKey.charAt(right);

            if(c == 'T')t++;
            else f++;

            //window becomes invalid if windowsize - max(t,f) + 2 > 0
            while(left < right && right - left + 1 - Math.max(t,f) - k > 0){
                char l = answerKey.charAt(left);
                if(l == 'T') t--;
                else f--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
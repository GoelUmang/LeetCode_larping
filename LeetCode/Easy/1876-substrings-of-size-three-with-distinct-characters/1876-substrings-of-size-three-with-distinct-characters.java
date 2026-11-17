class Solution {
    public int countGoodSubstrings(String s) {
       //clarifying questions
       // size ?
       // can be it non smol letters

        int[] freq = new int[26];

        int ans = 0;
        int len = s.length();
        int left = 0;

        for(int right = 0; right < len ; right++){
            //add
            char c = s.charAt(right);

            //remove if invalid
            while(right - left + 1 > 3 || freq[c-'a'] > 0){
                freq[s.charAt(left)-'a']--;
                left++;
                
            }
            freq[c-'a']++;

            if(right - left + 1 == 3)ans++;

            //store
        }
        return ans;
    }
}
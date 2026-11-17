class Solution {
    public int countGoodSubstrings(String s) {
       //clarifying questions
       // size ?
       // can be it non smol letters

        Set<Character> set = new HashSet<>();

        int ans = 0;
        int len = s.length();
        int left = 0;

        for(int right = 0; right < len ; right++){
            //add
            char c = s.charAt(right);

            //remove if invalid
            while(right - left + 1 > 3 || set.contains(c)){
                set.remove(s.charAt(left));
                left++;
                
            }
            set.add(c);

            if(right - left + 1 == 3)ans++;

            //store
        }
        return ans;
    }
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if(lenP > lenS) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        //freq array to store the freq of p
        int[] freqP = new int[26];
        //to store the freq of window of size p
        int[] freqS = new int[26];

        for(char c : p.toCharArray()){
            freqP[c-'a']++;
        }

        int left = 0;
        
        for(int right = 0; right < lenS; right++){
            //add char to our window;
            char c = s.charAt(right);

            //add the char freq
            freqS[c-'a']++;

            //check and remove if size > lenP; and left++
            if(right - left + 1 > lenP){
                freqS[s.charAt(left++) -'a']--;
            }
            //check if anagram
            if(right - left + 1 == lenP){
                //check and if yes toh add
                if(Arrays.equals(freqP, freqS)) list.add(left);
            }
            //store the left
            
        }
        return list;
    }
}
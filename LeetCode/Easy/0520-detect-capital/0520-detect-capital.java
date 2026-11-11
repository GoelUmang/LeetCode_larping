class Solution {
    public boolean detectCapitalUse(String word) {
       int capital = 0;
       int first = 0;
       //either capital == 0 , capital == 1 and at start , capitaal = word.length
       
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if( i == 0 && c - 'A' < 27){
                first++;
            }
            if(c - 'A' < 27){
                capital++;
            }

        }
        return (capital == 0) || (first == 1 && capital == 1) || (capital == word.length());
    }
}
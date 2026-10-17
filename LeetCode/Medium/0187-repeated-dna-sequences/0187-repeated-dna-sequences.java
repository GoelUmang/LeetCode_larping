class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() - 9; i++ ){
            //check if hashset contains this seq
            //adding unique
            if(seen.contains(s.substring(i, i+10))){
                ans.add(s.substring(i, i+10));   
            }
            seen.add(s.substring(i, i+10));
        }

        return new ArrayList<>(ans);
    }
}
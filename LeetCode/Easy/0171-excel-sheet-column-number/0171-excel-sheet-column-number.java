class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int titletoNum = 0;
        //base 26
        for(char c : columnTitle.toCharArray()){
            titletoNum += (c - 'A' + 1) * (Math.powExact(26, n-1));
            n--;
        }
        return titletoNum;
    }
}
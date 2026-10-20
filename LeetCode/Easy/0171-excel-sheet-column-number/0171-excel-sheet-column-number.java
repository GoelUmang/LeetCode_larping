class Solution {
    public int titleToNumber(String columnTitle) {

        int titletoNum = 0;
        //base 26
        for(int i = 0; i < columnTitle.length(); i++){
            //runing total 
            titletoNum = titletoNum * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return titletoNum;
    }
}
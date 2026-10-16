class Solution {
    public int countOdds(int low, int high) {
        //3 7 - total no = 5 - 2(both are odd)
        //1 - 9 - 5 = 9 - 4 
        // 3 8 - 3
        //2 7- 3
        //2 8 - 3
        if((high - low + 1) % 2 == 0) return (high - low + 1)/2;
        return( low % 2 != 0 || high % 2 != 0) ? ((high - low + 1) /2 ) + 1 : (high - low + 1)/2;
    }
}
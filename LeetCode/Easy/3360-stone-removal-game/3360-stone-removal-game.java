class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        int first = 0;
        while( n >= remove){
            n -= remove;
            remove--;
            first++;
        }
        return first % 2 == 1;
    }
}
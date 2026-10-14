class Solution {
    public boolean judgeCircle(String moves) {
        // 2d -> x and y axix
        // x + 1 if R and x-1 is L
        // same for y
        // return if x and y is 0;
        int x = 0;
        int y = 0;

        for(char c : moves.toCharArray()){
            if(c == 'U')y++;
            else if(c == 'D') y--;
            else if(c == 'R') x++;
            else x--;
        }
        return (x == 0 && y == 0);
    }
}
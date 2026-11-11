class Solution {
    public String[] createGrid(int m, int n) {
        //go to the right and then down
        String[] string = new String[m];
        for(int row = 0; row < m ; row++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0 ; col < n; col++){
                if(row != 0 && col < n - 1){
                    sb.append("#");
                }else sb.append(".");
            }
            string[row] = sb.toString();
        }
        return string;
    }
}
class Solution {
    public int countServers(int[][] grid) {
        //for each row and col check if it is connedted ,and then add
        int connected = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] rowArr = new int[m];
        int[] colArr = new int[n];


        //just fill how manuy server in an array
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n ; col++){
                if(grid[row][col] == 1){
                    rowArr[row]++;
                    colArr[col]++;
                }
            }
        }
        //see if the curr is 1 and (row or col has one ohter)

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1 && (rowArr[row] > 1 || colArr[col] > 1)){
                    connected++;
                }
            }
        }
        return connected;
    }
}
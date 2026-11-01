class Solution {
    int m , n;
    int[][] directions = {
        {0,1}, {1,0}, {-1, 0}, {0,-1}
    };
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        //just have to modify in place 
        //for all O in the matrix not in the boundry
        //backtrack from the boundry where O mark them as # as dont change
        //and then move all the X to 0
        // Step 1: Check left and right boundaries
        // step 2 : same for col 
        // step 3 do the rest to 0 and # to X back again
        for(int row = 0 ; row < m ; row++){
            if(board[row][0] == 'O'){
                //first col
                dfs(board, row, 0);
            }
            //last col
            if(board[row][n-1] == 'O'){
                dfs(board, row, n-1);
            }
        }

        for(int col = 0 ; col < n ; col++){
            if(board[0][col] == 'O'){
                //first col
                dfs(board, 0, col);
            }

            //last col
            if(board[m-1][col] == 'O'){
                dfs(board, m-1,col);
            }
        }

        //now at this point we have to just mark o to x , cox the boundry o;s are marked as # 
        for(int row = 0 ; row < m ; row++){
            for(int col = 0 ; col < n ; col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
                else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }

        //mark the boundry O to the #
    public void dfs(char[][] board, int row, int col) {
        // Base case out of bounds
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            board[row][col] != 'O') {
            return;
        }
        // Mark visited, change to ) afterwards 
        board[row][col] = '#';

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            dfs(board, nextRow, nextCol);
        }
    }
}
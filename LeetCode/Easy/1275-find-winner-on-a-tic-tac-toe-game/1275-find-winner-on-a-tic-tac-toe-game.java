class Solution {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        //BASE CASE
        if(n < 5) return "Pending";

        //Player A places x and B places O
        //row, col, dia for winning 
        // end can be a draw, win, 

        // return the winner if any, "DRAW" for draw ie no moves left
        // Pending is not win and moves.length is less than 9 

        //simulation
        //0 for no moves, 1 for A, -1 for B. 
        int[][]grid = new int[3][3];
        for(int i = 0; i < n; i++){
            int row = moves[i][0];
            int col = moves[i][1];
            if(i % 2 == 0){//A chance
                grid[row][col] = 1;
            }else grid[row][col] = -1;
        }

        //basiec check 
        //if sum is 3 for dia anti dia row or col A wins 
        //if sum in -3 B wins
        // if none and moves < 9 pending
        //else draw

        //diagonal
        int dia = 0;
        int antiDia = 0;

        for(int i = 0 ; i < 3 ; i++){
            dia += grid[i][i];
            antiDia += grid[i][3 - i - 1];
        }
        if(dia == 3) return "A";
        if(antiDia == 3) return "A";

        if(dia == -3) return "B";
        if(antiDia == -3) return "B";

        //antidiagonal
        
        for(int i = 0 ; i < 3 ; i++){
            int sumRow = 0;
            int sumCol = 0;
            for(int j = 0 ; j < 3; j++){
                sumRow += grid[i][j];
                sumCol += grid[j][i];
            }
            if (sumRow == 3 || sumCol == 3) return "A";
            if (sumRow == -3 || sumCol == -3) return "B";
        }
        
        //no win till now 

        if(moves.length < 9) return "Pending";

        return "Draw";
    }
}
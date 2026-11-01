class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int count = 0;

        int[] colCount = new int[n];
        int[] rowCount = new int[m];

        //storing the which col and col has the B
        for(int row = 0; row < m ; row++){
            for(int col = 0; col < n; col++){
                if(picture[row][col] == 'B'){
                    colCount[col]++;
                    rowCount[row]++;
                }
            }
        }
        //now we have the positon of where B is in row and col
        //second pass to check where any other places contains B
        for(int row = 0; row < m ; row++){
            //if row doesnt have b continue
            if(rowCount[row] != 1) continue;
            for(int col = 0; col < n; col++){
                if(picture[row][col] == 'B' && colCount[col]== 1){
                    count++;
                }
            }
        }
        return count;
    }
    //     int m = picture.length;
    //     int n = picture[0].length;
    //     int count = 0;
    //    //brute force 
    //     for(int row = 0; row < m ; row++) {
    //         for(int col = 0; col < n ; col++){
    //             if(picture[row][col] == 'B'){
    //                 //check if the row has b and col 
    //                 boolean rowCheck = checkRow(picture[row], row, col);
    //                 boolean colCheck = checkCol(picture, row, col);
    //                 if(rowCheck && colCheck) count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    // private boolean checkRow(char[] picture, int row, int col){
    //     //row = 0
    //     //col = 2
    //     for(int i = 0; i < picture.length; i++ ){
    //         if(i == col) continue;
    //         if(picture[i] == 'B') return false;
    //     }
    //     return true;
    // }

    // private boolean checkCol(char[][] picture, int rowPos, int colPos){
    //     //row = 0
    //     //col = 2
    //     for(int row = 0; row < picture.length ; row++){
    //         if(row == rowPos)continue;
    //         if(picture[row][colPos] == 'B') return false;
    //     }
    //     return true;
    // }
}
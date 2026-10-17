class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //first row all the elemtns
        //last col()
        //
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m -1;
        
        int startCol = 0;
        int endCol = n - 1;
        
        List<Integer> ans = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol){
            //-->
            int tempCol = startCol;
            while(tempCol <= endCol){
                ans.add(matrix[startRow][tempCol++]);
            }
            startRow++;


            // |
            // >
            int tempRow = startRow;

            while(tempRow <= endRow){
                ans.add(matrix[tempRow++][endCol]); 
            }


            endCol--;

            if (startRow <= endRow) {
                tempCol = endCol;
                while (tempCol >= startCol) {
                    ans.add(matrix[endRow][tempCol--]);
                }
                endRow--;
            }

            if (startCol <= endCol) {
                tempRow = endRow;
                while (tempRow >= startRow) {
                    ans.add(matrix[tempRow--][startCol]);
                }
                startCol++;
            }
        }
        return ans;
    }
}
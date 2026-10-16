class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        //slope method
        int xdiff = xDiff(coordinates[1] , coordinates[0]);
        int ydiff = yDiff(coordinates[1] , coordinates[0]);

        for(int i = 2 ; i < coordinates.length ;i++ ){
            if( ydiff * xDiff(coordinates[i],coordinates[i-1])
                != xdiff * yDiff(coordinates[i],coordinates[i-1])
            )return false;
        }
        return true;
    }

    public int xDiff(int[] point1 , int[] point2){
        return (point2[1] - point1[1]);
    }

    public int yDiff(int[] point1 , int[] point2){
        return(point2[0] - point1[0]);
    }
}
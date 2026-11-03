class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        //sort
        //chekc for the formula x1-x2 <= w 
        //inc count
        Arrays.sort(points, ((a,b) -> Integer.compare(a[0], b[0])));
        //x2 - x1 <= w
        int rectangleCount = 0;

        int span = -1;
        for(int i = 0; i < points.length; i++){
            if(points[i][0] > span){
                rectangleCount++;
                span = points[i][0] + w;
            }
        }
        return rectangleCount;
    }
}
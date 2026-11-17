class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if(mainTank < 5) return mainTank * 10 ;
        int totalDis = 0;
        while(mainTank > 0){
            int used = Math.min(mainTank, 5);
            totalDis += used * 10;
            mainTank -= used;
            if(used == 5 && additionalTank > 0){
                mainTank++;
                additionalTank--;
            } 
        }
        return totalDis;
    }
}
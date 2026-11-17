class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return (mainTank + Math.min(additionalTank, (mainTank - 1) / 4)) * 10;
    }
}
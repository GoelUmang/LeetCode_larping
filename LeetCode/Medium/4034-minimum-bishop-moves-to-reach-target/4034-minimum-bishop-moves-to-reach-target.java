class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        //if(Math.abs(source[0] + source[1]) % 2 != Math.abs(target[0] - target[1]) % 2 ) return -1;
        if (((source[0] + source[1]) - (target[0] + target[1])) % 2 != 0) return -1;
        if(Math.abs(source[0] - target[0]) == Math.abs(source[1] - target[1])) return 1;
        return 2;
    }
}
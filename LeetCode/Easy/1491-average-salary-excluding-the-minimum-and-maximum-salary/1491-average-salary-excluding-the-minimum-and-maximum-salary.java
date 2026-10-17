class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int num : salary){
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum += num;
        }
        return (double)(sum - max - min)/(salary.length - 2);

        // Arrays.sort(salary);
        // double ans = 0;
        
        // for(int i = 1; i < salary.length - 1; i++){
        //     ans += salary[i];
        // }
        // return ans/(salary.length - 2);

    }
}
class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        //pair method
        for(int i = 1; i * i < num; i++){
            if(num % i == 0){
                sum += i;
                //for 28 = 2 * 14 so we did 2 above this now do 14 
                if( i != num / i){
                    sum += num/ i;
                }
            }
        }
        // for(int i = 1; i <= num/2 ; i++){
        //     if(num % i == 0)sum +=i;
        // }
        return(sum - num == num);
    }
}
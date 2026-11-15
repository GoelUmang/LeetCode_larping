class Solution {
    public int numOfSubarrays(int[] arr) {

    // ALl oddd elemnets are a subaraay itself
    // odd and even 
    //summ can be off if
    // there are euqla not amount of off and even 
    //in order words no of subarrys is 
    //all odd + no of (odd , even) pair
    //and (odd no of odd)
    long ans = 0 ;
    long sum = 0;
    int mod = 1000000007;
    int oddSum = 0, evenSum = 1;//0 ahhhh is even
    for(int i = 0; i < arr.length; i++){
        int num = arr[i];

        sum+= num;

        if(sum % 2 == 0){
            //even
            ans = (ans + oddSum) % mod;
            evenSum++;
        }else{
            ans = (ans + evenSum) % mod;
            oddSum++;
        }
    }
    return (int) ans;
    }
}
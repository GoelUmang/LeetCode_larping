class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        //even length
        //put even number in even idx
        //put odd number in odd indx
        int odd = 1;

        //case 1 : at correct poision ie even number and even index or opp
        //case 2 : swap
        for(int i = 0; i < nums.length; i+=2){
            if(nums[i] % 2 != 0){//odd num on even
                while(nums[odd] % 2 != 0){ //find the even number on odd idx
                    odd += 2;
                }
                //found the number
                //swap
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;





        //int[] ans = new int[nums.length];

        // for(int i = 0; i < nums.length ; i++){
        //     //num is odd
        //     if(nums[i] % 2 != 0){
        //         ans[odd] = nums[i];
        //         odd += 2;
        //     }else{ 
        //         ans[even] = nums[i];
        //         even += 2;
        //     }

        // }  
        //return ans;
    }    
}
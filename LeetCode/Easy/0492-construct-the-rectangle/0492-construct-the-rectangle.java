class Solution {
    public int[] constructRectangle(int area) {
        //rule 1 The width W should not be larger than the length L, which means L >= W.
        // The difference between length L and width W should be as small as possible.
        //Return an array [L, W] where L and W are the length and width
        
        // prime factor pair 
        // follows the first rule and then min 
        int [] ans = new int[2];
        int minwidth = Integer.MAX_VALUE;
        for(int i = 1; i * i <= area ; i++){
            //pair part 
            if(area % i == 0 ){
                //got the first element and now check for pair
                int complement = area / i ;
                if( i * complement <= minwidth){
                    minwidth = i * complement;
                    if(i < complement){
                        ans[0] = complement;
                        ans[1] = i;
                    }else{
                        ans[1] = complement;
                        ans[0] = i;
                    }
                }
            }
        }
        return ans;
    }
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //for every element in arr 1 
        // check every elemnt in arr 2 
        // if mod |arr1[i] - arr2[j]| > d  for all element

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int ans = 0 ;

        for(int i = 0 ; i < arr1.length ; i++){
            ans++;
            for(int j = 0; j < arr2.length ;j++){
                if(Math.abs(arr1[i] - arr2[j]) <= d){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
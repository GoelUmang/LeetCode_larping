class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m + n];
        int index1 = 0; 
        int index2 = 0;
        int i = 0;

        while(index1 < m && index2 < n){
            if(nums1[index1] <= nums2[index2]){
                temp[i] = nums1[index1];
                index1++;

            }else{
                temp[i] = nums2[index2];
                index2++;
            }
            i++;
        }
        
            while(index1 < m){
                temp[i] = nums1[index1];
                index1++;
                i++;
            }
            while(index2 < n) {
                temp[i] = nums2[index2];
                index2++;
                i++;
            }

        double median = 0;
        //total = 4, mid = 4/2 = 2
        //now our array is populated 
        int lengthOfTemp = temp.length;
        if(lengthOfTemp % 2 ==0){
            int first = lengthOfTemp/2;
            int second = first - 1;
            median = (temp[first] + temp[second])/2.0;
            //
        }else{
            //the length is odd for odd 
            //for eg 3 the medium is at element length/2;
            median = temp[lengthOfTemp/2];
        }
        return median;
    }
}
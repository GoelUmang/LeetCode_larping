class Solution {
    //kind of taken from q295, but this is extended part,
    // using the addNum fn from prev question
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//so 456
    int minSize, maxSize; //no of valid elements
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//321
    int k = 0;

    //for storing what needs to be deleteted
    Map<Integer, Integer> hashMap = new HashMap<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        int n = nums.length;
        double[] ans = new double[n-k+1];

        //length of the window wil be the k size so we need 
        //if the k is even then middle two values
        
        int left = 0;
        for(int right = 0; right < n ; right++){

                addNum(nums[right]);
            
            if(right - left + 1 > k){
                removeNum(nums[left]);
                left++;
            }
            if(right - left + 1 == k){
                ans[left] = findMedian();
            }
        }
        return ans;
    }

    public void addNum(int num) {   
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            maxSize++;
        } else {
            minHeap.add(num);
            minSize++;
        }
        rebalance();
    }
    

    private void rebalance() {
    // Move elements based on logical sizes
        if(maxSize > minSize + 1){
            removeFromHeap(maxHeap);
            minHeap.add(maxHeap.remove());
            maxSize--;
            minSize++;
            removeFromHeap(maxHeap);
        }else if (minSize > maxSize){
            removeFromHeap(minHeap);
            maxHeap.add(minHeap.remove());
            minSize--;
            maxSize++;
            removeFromHeap(minHeap);
        }
    }   

    //if element leave the window add ot hashmap and reduce the count of size
    public void removeNum(int num){
        hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        //which heap was it in
        if(num <= maxHeap.peek()){ //maxheap has 3 2 1 and delettion of 2 
            maxSize--;
            removeFromHeap(maxHeap);

        }else{
            minSize--;
            removeFromHeap(minHeap);
        }

        rebalance();
    }

    private double findMedian() {
        if(k % 2 == 0){
            //even
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;

        }
        return maxHeap.peek();
    }   

    private void removeFromHeap(PriorityQueue<Integer> heap) {
        while(!heap.isEmpty() && 
            hashMap.getOrDefault(heap.peek(), 0) >= 1){
                
                //reduce the freq by 1 
                hashMap.put(heap.peek(), hashMap.getOrDefault(heap.peek(), 0) - 1 );

                // clean up if empty
                if(hashMap.get(heap.peek()) == 0) hashMap.remove(heap.peek());

                heap.remove();
        }
    }

}
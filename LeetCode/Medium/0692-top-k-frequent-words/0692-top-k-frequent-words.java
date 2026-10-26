class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //intial thought
        // hahsmap
        Map<String, Integer> hash = new HashMap<>();
        //word - freq
        for(String string : words){
            hash.put(string, hash.getOrDefault(string, 0) + 1);
        }

        //store the freq onto the heap of size k 
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int freqCompare = hash.get(a) - hash.get(b);
            //not equal &&
            //if a is bigger +ve means a gets return
            //if b is bigger ie -ve b gets return 
            if(freqCompare != 0) return freqCompare;
            //if equal then return the smaller is kept
            return b.compareTo(a);
        });

        for (String word : hash.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //store the freq words
        //return those freq mapped to the string in the list
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }        
}

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
      //have to return the list of the busiest server 
      //ie if all are busiest of 3 so all have to be returned
      //but if one got 4 so just return the one 

      //  heap by server number and their end time
      PriorityQueue<Integer> free = new PriorityQueue<>((a, b) -> Integer.compare(a,b));
      PriorityQueue<int[]> busyHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

      //all are free at start
      for(int i = 0; i < k ;i++){
        free.add(i);
      }

      int[] count = new int[k];

      //for each server, decide which server they shuld be given
      for(int i = 0 ; i < arrival.length; i++){
        int start = arrival[i];

        //remove from free, change id
        while(!busyHeap.isEmpty() && busyHeap.peek()[0] <= start){
            int serverId = busyHeap.poll()[1];
            //int modify = ((serverId - i)) % k + i;
            int modify = (serverId - i % k + k) % k + i;
            free.add(modify);
        }

        //assign
        if (!free.isEmpty()) {
            int busyId = free.peek() % k;
            free.remove();
            busyHeap.offer(new int[]{start + load[i] , busyId});
            count[busyId]++;
        }
      }

      // Find the max 
      int max = 0;
      for(int job : count) max = Math.max(job, max);

      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                list.add(i);
            }
        }
        return list;
    }
}
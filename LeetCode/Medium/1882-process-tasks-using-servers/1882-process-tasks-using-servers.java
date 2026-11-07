class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //using the 2 heap
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        //available heap
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a,b) -> a[0] != b[0] ?
            Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        //occupied one heap free, weight , i
        PriorityQueue<long[]> occupied = new PriorityQueue<>(
            (a,b) -> {
                if(a[0] != b[0]) return Long.compare(a[0], b[0]);
                if(a[1] != b[1]) return Long.compare(a[1], b[1]);
                return Long.compare(a[2],b[2]);
            }
        );

        for(int i = 0 ; i < n; i++) available.offer(new int[]{servers[i], i});

        long time = 0;

        for(int i = 0; i < m; i++){

            //task i arrive at sec j
            time = Math.max(time, (long)i);

            //if all busy take next
            if(available.isEmpty()){
                time = Math.max(time, occupied.peek()[0]);
            }

            //relse who is free
            while(!occupied.isEmpty() && occupied.peek()[0] <= time){
                long[] server = occupied.poll();
                available.offer(new int[]{
                    (int) server[1], (int) server[2]
                });
            }

                int[] ser = available.poll();
                ans[i] = ser[1];

                //sch the server next available time
                occupied.offer(new long[]{
                    time+ tasks[i], ser[0], ser[1]
                });
            }
        
        return ans;
    }
}
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // n : the total number of servers
        // logs[i] = [server_id, time]
        // Return a 0-indexed integer array arr of length queries.length
        // where arr[i] represents the number of servers that did not receive any 
        //requests during the time interval [queries[i] - x, queries[i]].

        //some clearify question:
        //how big n can be 
        // can the quwesries be negative or 0
        //what is x here 
        //

        //so intial sort it out based on the 

        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));
        int[][] newQuery = new int[queries.length][2];

        for(int i = 0; i < queries.length; i++){
            newQuery[i][0] = i;
            newQuery[i][1] = queries[i];
        }

        Arrays.sort(newQuery, (a,b) -> Integer.compare(a[1], b[1]));
        
        //now sotring quesy but have to maintain the order 

        /* then have to maintain the sliding window 
        For each query q, our window is [q - x, q].
        Move the window over the sorted logs.
        */
        int left = 0;
        int right = 0;
        int active = 0;
        int[] count = new int[n + 1];
        int[] ans = new int[queries.length];

        for(int[] query : newQuery){
            int index = query[0];
            int q = query[1];

            int start = q - x; 

            //add req with time < = q
            while(right < logs.length && logs[right][1] <= q){
                int serverID = logs[right][0];

                if(count[serverID] == 0){
                    active++;
                }
                count[serverID]++;
                right++;
            }
            
            //npw remove req and move left ++;
            while(left < right && logs[left][1] < start){
                int server_id = logs[left][0];
                count[server_id]--;
                
                if(count[server_id] == 0){
                    active--;
                }
                left++;
            }
        ans[index] = n - active;
        }
        return ans;
    }
}
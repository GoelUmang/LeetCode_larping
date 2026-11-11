class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

       
        //at every step we can check which ever is cheaper 

        long carry = Math.min(need1, need2);
        long cost = carry * Math.min(cost1+cost2, costBoth);

        if(need1 > need2){
            cost += (need1 - carry) * Math.min(costBoth, cost1);
        }else cost += (need2 - carry) * Math.min(costBoth, cost2);

        //give tle for current op
        // while(need1 > 0 || need2 > 0){   
        //     // we can check level by level
        //     // if both < cost 1 + cost 2 (use that)
        //     if((costBoth < cost1 + cost2) && need1 > 0 && need2 > 0){
        //         cost += costBoth;
        //     }else if((costBoth < cost1) && need2 < 1){
        //         cost += costBoth;
        //     }else if((costBoth < cost2) && need1 < 1){
        //         cost += costBoth;
        //     }else{
        //         if(need1 > 0) cost+= cost1;
        //         if(need2 > 0) cost+= cost2;
        //     }
        //     need1--;
        //     need2--;
            
        // }
        return cost;
    }
}
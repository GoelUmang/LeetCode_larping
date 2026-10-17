class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cost = 5;
        //bills[i] is either 5, 10, or 20.
        //deteremine that we can give correct change
        int five = 0;
        int ten = 0;

        for(int i = 0; i < bills.length ;i++){
            int currBill = bills[i];
            //5 add it 
            if(currBill == 5){
                five++;
            }
            //gave 10 , we have 5 ok, we no have 5 no ok
            else if (currBill == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else return false;
            }
            else if(ten > 0 && five > 0){
                ten--;
                five--;
            }
            else if(five > 2){
                five -= 3;
            }else return false;
        }
        return true;
    }
}
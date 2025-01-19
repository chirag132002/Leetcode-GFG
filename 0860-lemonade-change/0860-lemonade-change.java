class Solution {
    public boolean lemonadeChange(int[] bills) {
       int countFive = 0;
       int countTen = 0;
       for(int i = 0; i<bills.length; i++){
        if(bills[i]==5){
            countFive +=1;
        }
        else if(bills[i] == 10){
            if(countFive>0){
                countFive -= 1;
            countTen += 1;
            }else{
                return false;
            }
        }
        else{
            if(countFive>0 && countTen>0){
                countTen-=1;
                countFive-=1;
            }else if(countFive>=3){
                  countFive-=3;
            }
            else{
                return false;
            }
        }
       } 
       return true;
    }
}
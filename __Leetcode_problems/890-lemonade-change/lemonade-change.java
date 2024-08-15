class Solution {
    public boolean lemonadeChange(int[] bills) {
        int note5= 0;
        int note10= 0;
        for(int i=0; i< bills.length; i++){
            if(bills[i] == 5){
                note5++;
            }
            else if(bills[i] == 10){
                note10++;
                if(note5 == 0){
                    return false;
                }
                note5--;
            }
            else{
                if(note10 > 0 && note5 > 0 ){
                    note10--;
                    note5--;
                    continue;
                }
                if(note5 == 0){
                    return false;
                }
                if(note10 == 0){
                    if(note5 < 3){
                        return false;
                    }
                    note5 = note5-3;
                    continue;
                }
            }
        }
        return true;
    }
}
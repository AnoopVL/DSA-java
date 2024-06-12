class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> finalList = new ArrayList<>();
        int highestCandy = 0;
        for(int i = 0; i < candies.length;i++){
            if(candies[i] >= highestCandy){
                highestCandy = candies[i];
            }
        }
        for(int i = 0; i < candies.length; i++){
            candies[i]+=extraCandies;
            if(candies[i] >= highestCandy){
                finalList.add(true);
            }
            else{
                finalList.add(false);
            }
        }
        return finalList;
        // for(int i = 0; i < candies.length; i++){
        //     int highestCandy = candies[i] + extraCandies;
        //     candies[i] = highestCandy;
        //     for(int j = 0; j < candies.length; j++){
        //         if(highestCandy >= candies[i] ){
        //             finalList.add(true);
        //         }
        //         else{
        //             finalList.add(false);
        //         }
        //     }
        // }
        // return finalList;
    }
}
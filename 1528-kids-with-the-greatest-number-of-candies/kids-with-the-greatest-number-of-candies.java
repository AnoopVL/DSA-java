class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> finalList = new ArrayList<>();
        int highestCandy = 0;
        for(int candy : candies){
            highestCandy = Math.max(highestCandy, candy);
        }
        for(int candy : candies){
            if(candy + extraCandies >= highestCandy){
                finalList.add(true);
            }
            else{
                finalList.add(false);
            }
        }
        return finalList;
    }
}
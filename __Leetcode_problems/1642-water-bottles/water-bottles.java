class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        while(numBottles >= numExchange){
            int empty = numBottles % numExchange;
            numBottles /= numExchange;
            total += numBottles;
            numBottles += empty;
        }
        return total;
    }
}
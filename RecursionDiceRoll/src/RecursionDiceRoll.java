// Q. When a target is given find all the possible ways to get the taget by throwing the dice

import java.util.ArrayList;

/**
 * RecursionDiceRoll
 */
public class RecursionDiceRoll {

    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceArrList("", 3));
        System.out.println(diceCombinationCount("", 3));
    }
    public static void dice(String proString, int target){
        if (target == 0) {
            System.out.println(proString);
            return;
        }
        for (int i = 1; i <=6 && i <= target; i++) {
            dice(proString + i, target - i);
        }
    }

    public static ArrayList<String> diceArrList(String proString, int target){
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(proString);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <=6 && i <= target; i++) {
            list.addAll(diceArrList(proString + i, target - i));
        }
        return list;
    }

    public static int diceCombinationCount(String proString, int target){
        int count = 0;
        if (target == 0) {
            // System.out.println(proString);
            return 1;

        }
        for (int i = 1; i <=6 && i <= target; i++) {
            count = count + diceCombinationCount( proString + i, target-i);
        }
        return count;
    }


}
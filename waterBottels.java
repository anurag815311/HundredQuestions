/*There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

 

Example 1:


Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13. */

//package HundredQuestions;

public class waterBottels {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int remBottles = numBottles % numExchange;
            ans += newBottles;
            numBottles = newBottles + remBottles;
        }
        return ans;
    }

    public static void main(String[] args) {
        waterBottels w = new waterBottels();
        int result = w.numWaterBottles(15, 4);
        System.out.println(" " + result);

    }
}

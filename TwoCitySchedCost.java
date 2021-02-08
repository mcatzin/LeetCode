import java.util.Arrays;

/*
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], 
the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.

Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110

Time: O(NlogN) O(1)
*/

public class TwoCitySchedCost {

  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b) -> (a[0] - b[0]) - (a[1] - b[1]));

    int minCost = 0;
    for (int i = 0; i < costs.length / 2; i++) {
      minCost += costs[i][0];
      minCost += costs[costs.length / 2 + i][1];
    }

    return minCost;
  }
}

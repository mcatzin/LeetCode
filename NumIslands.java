/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 
*/

public class NumIslands {
  public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int numOfIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          numOfIslands += dfs(grid, i, j);
        }
      }
    }

    return numOfIslands;
  }

  private int dfs(char[][] grid, int row, int col) {
    int gridRow = grid.length;
    int gridCol = grid[0].length;
    if (row < 0 || row >= gridRow || col < 0 || col >= gridCol || grid[row][col] == '0') {
      return 0;
    }

    grid[row][col] = '0';
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);

    return 1;

  }
}

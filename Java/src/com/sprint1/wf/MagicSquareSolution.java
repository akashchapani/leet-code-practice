package com.sprint1.wf;

public class MagicSquareSolution {

    public static void main(String[] args) {
        MagicSquareSolution solution = new MagicSquareSolution();
        int[][] grid = {{7, 3, 8}, {7, 6, 5}, {4, 9, 5}};
        System.out.println("Magic Grid Size: " + solution.solution(grid));
        int[][] grid2 = {{4, 3, 4, 5, 3}, {2, 7, 3, 8, 4}, {1, 7, 6, 5, 2}, {8, 4, 9, 5, 5}};
        System.out.println("Magic Grid Size: " + solution.solution(grid2));
        int[][] grid3 = {{2, 3, 1, 1}, {2, 2, 2, 2}, {1, 2, 2, 2}};
        System.out.println("Magic Grid Size: " + solution.solution(grid3));
        int[][] grid4 = {{7, 2, 4}, {2, 7, 6}, {9, 5, 1}, {4, 3, 8}, {3, 5, 4}};
        System.out.println("Magic Grid Size: " + solution.solution(grid4));
        
        int[][] grid5 = {{4, 3, 4,5,5}, 
        		        {2, 7, 3,5,5},
        		        {1,2,3,4,5}};
        System.out.println("Magic Grid Size test: " + solution.solution(grid5));
    }
    

    public int solution(int[][] grid) {
        int magicSize = Math.min(grid.length, grid[0].length);
        while (magicSize > 1) {
            int rowEnd = grid.length - magicSize;
            int colEnd = grid[0].length - magicSize;
            for (int row = 0; row <= rowEnd; row++) {
                for (int col = 0; col <= colEnd; col++) {
                    if (isMagicSquare(grid, row, col, magicSize)) {
                        System.out.println("Magic grid indices: [" + row + "][" + col + "], [" + row + "]["
                                + (col + (magicSize - 1)) + "], [" + (row + (magicSize - 1)) + "][" + col + "], ["
                                + (row + (magicSize - 1)) + "][" + (col + (magicSize - 1)) + "]");
                        return magicSize;
                    }
                }
            }
            magicSize--;
        }
        // Default magic size
        return 1;
    }

    // Expecting a square array
    private boolean isMagicSquare(int[][] grid, int rowStart, int colStart, int gridSize) {
        long magicSum = 0;
        // calc grid boundary
        int rowEnd = rowStart + gridSize;
        int colEnd = colStart + gridSize;
        // Calc row sum
        for (int row = rowStart; row < rowEnd; row++) {
            int sum = 0;
            for (int col = colStart; col < colEnd; col++) {
                sum += grid[row][col];
            }
            if (magicSum == 0)
                magicSum = sum;
            if (magicSum != sum)
                return false;
        }
        // Calc col sum
        for (int col = colStart; col < colEnd; col++) {
            int sum = 0;
            for (int row = rowStart; row < rowEnd; row++) {
                sum += grid[row][col];
            }
            if (magicSum != sum)
                return false;
        }
        // Calc diagonal sum
        int sum = 0;
        for (int row = rowStart, col = colStart; row < rowEnd; row++, col++) {
            sum += grid[row][col];
        }
        if (magicSum != sum)
            return false;
        sum = 0;
        for (int row = rowStart, col = colEnd - 1; row < rowEnd; row++, col--) {
            sum += grid[row][col];
        }
        if (magicSum != sum)
            return false;
        return true;
    }
}

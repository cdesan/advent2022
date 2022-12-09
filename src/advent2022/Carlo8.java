package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo8 {
	
	
	public static int visitLeft(int[][] grid, int row, int col) {
		
		int n = grid[row][col];
		
		if(col-1 < 0) {
			return 0;
		}
		
		int dist = 0;
		for(int i = col-1; i >= 0; i--) {
			if(grid[row][i] >= n) {
				dist = i;
				break;
			}
			dist = i;
		}
		
		return Math.abs(col-dist);
	}
	
	public static int visitRight(int[][] grid, int row, int col) {
		
		int n = grid[row][col];
		
		int dist = 0;
		
		if(col+1 >= grid[row].length) {
			return 0;
		}
		
		for(int i = col+1; i < grid[row].length; i++) {
			if(grid[row][i] >= n) {
				dist = i;
				break;
			}
			dist = i;

		}
			
		return Math.abs(col-dist);
		
	}
	public static int visitUp(int[][] grid, int row, int col) {
		
		int n = grid[row][col];
		
		int dist = 0;
		
		if(row-1 < 0) {
			return 0;
		}
		
		for(int i = row-1; i >= 0; i--) {
			if(grid[i][col] >= n) {
				dist = i;
				break;
			}
			dist = i;

		}
		
		return Math.abs(row-dist);
		
	}
	public static int visitDown(int[][] grid, int row, int col) {
		int n = grid[row][col];
		
		int dist = 0;
		
		if(row+1 >= grid.length) {
			return 0;
		}
		
		for(int i = row+1; i < grid.length; i++) {
			if(grid[i][col] >= n) {
				dist = i;
				break;
			}
			dist = i;

		}
		
		return Math.abs(row-dist);
	}
		
	
	public class Part1 {
				
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input8.txt";
			Scanner scanner = new Scanner(new File(file_path));
			
			int rowCount = 99;
			int colCount = 99;

			System.out.println(rowCount + " " + colCount);
			int[][] grid = new int[rowCount][colCount];
			int row = 0;
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				int l = s.length();
				for(int i = 0; i < l; i++) {
					int heightVal = s.charAt(i)-48;
					grid[row][i] = heightVal;
				}
		
				row++;
			}
			
			int maxScore = -1;

			for(int i = 0; i < rowCount; i++) {
				for(int j = 0; j < colCount; j++) {
					int upScore = visitUp(grid, i ,j);
					int rightScore = visitRight(grid,i,j);

					int downScore = visitDown(grid,i,j);

					int leftScore = visitLeft(grid,i,j);
					
					int totalScore = upScore * rightScore * downScore * leftScore;
					maxScore = Math.max(maxScore, totalScore);
					
				}
			}
			
			System.out.println(maxScore);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Part1.Solve();
	}

}

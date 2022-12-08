package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo8 {
	
	public static class Tree{
		
		public int leftHeight = -2;
		public int upHeight = -2;
		public int rightHeight = -2;
		public int downHeight = -2;
		
		public int height;
		
		public boolean visibleLeft = false;
		public boolean visibleUp = false;
		public boolean visibleRight = false;
		public boolean visibleDown = false;

				
		public Tree(int height) {
			this.height = height;
		}
		
	
		public boolean isViewable() {
			return this.visibleLeft || this.visibleUp || this.visibleRight || this.visibleDown;
		}
		
		
		public String toString() {
			if(this.isViewable()) {
				return "*";
			}
			else {
				return "-";
			}
		}
	}
	
	public static int visitLeft(Tree[][] grid, int row, int col) {
		
		Tree n = grid[row][col];
		if(n.leftHeight != -2) {
			return n.leftHeight;
		}
		else {
			int left = visitLeft(grid, row, col-1);
			
			n.leftHeight = Math.max(n.height, left);
			
			if(left < n.height) {
				n.visibleLeft = true;
			}
			
			return n.leftHeight;
		}
	}
	
	public static int visitRight(Tree[][] grid, int row, int col) {
		
		Tree n = grid[row][col];
		if(n.rightHeight != -2) {
			return n.rightHeight;
		}
		else {
			int right = visitRight(grid, row, col+1);
			n.rightHeight = Math.max(n.height, right);
			if(right < n.height) {
				n.visibleRight = true;
			}
			return n.rightHeight;
		}
		
	}
	public static int visitUp(Tree[][] grid, int row, int col) {
		
		Tree n = grid[row][col];
		
		if(n.upHeight != -2) {
			return n.upHeight;
		}
		else {
			
			int up = visitUp(grid, row-1, col);
			
			n.upHeight = Math.max(n.height, up);
			
			if(up < n.height) {
				n.visibleUp = true;
			}

			return n.upHeight;
		}
		
	}
	public static int visitDown(Tree[][] grid, int row, int col) {
		
		Tree n = grid[row][col];
		
		if(n.downHeight != -2) {
			return n.downHeight;
		}
		else {
			
			int down = visitDown(grid, row+1, col);
			
			n.downHeight = Math.max(n.height,  down);
			
			if(down < n.height) {
				n.visibleDown = true;
			}
			
			return n.downHeight;
		}
		
	}
		
	
	public class Part1 {
				
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input8.txt";
			Scanner scanner = new Scanner(new File(file_path));
			
			int rowCount = 99;
			int colCount = 99;

			System.out.println(rowCount + " " + colCount);
			Tree[][] grid = new Tree[rowCount][colCount];
			int row = 0;
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				int l = s.length();
				for(int i = 0; i < s.length(); i++) {
					int heightVal = s.charAt(i)-48;
					grid[row][i] = new Tree(heightVal);
					
					if(row == 0) {
						grid[row][i].upHeight = grid[row][i].height;
						grid[row][i].visibleUp = true;
					}
					if(row == grid.length - 1) {
						grid[row][i].downHeight = grid[row][i].height;
						grid[row][i].visibleDown = true;
					}
					if(i == 0) {
						grid[row][i].leftHeight = grid[row][i].height;
						grid[row][i].visibleLeft = true;
					}
					if(i == grid[i].length-1) {
						grid[row][i].rightHeight = grid[row][i].height;
						grid[row][i].visibleRight = true;
					}
				}
				row++;
			}
			
					
			//Debug print loop
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					visitLeft(grid, i, j);
					visitUp(grid, i, j);
					visitRight(grid, i, j);
					visitDown(grid, i, j);
				}
			}
			
			
			int result = 0;
			//Debug print loop
			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					System.out.print(grid[i][j]);
					if(grid[i][j].isViewable()) {
						result++;
					}
				}
				System.out.print("\n");
			}
			
			System.out.println(result);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Part1.Solve();
	}

}

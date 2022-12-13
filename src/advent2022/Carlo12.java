package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Carlo12 {
	
	public static class Node {
		
		public ArrayList<Node> neighbors;
		public boolean visited;
		public int dist;
		int val;
		
		public Node(int val) {
			this.neighbors = new ArrayList<Node>();
			this.val = val;		
			this.dist = Integer.MAX_VALUE;		
			this.visited = false;
		}
	}	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String file_path = "input12.txt";
		
		Scanner scanner = new Scanner(new File(file_path));
		
		ArrayList<String> lines = new ArrayList<String>();
		
		while(scanner.hasNextLine()) {
			String s = scanner.nextLine();
			lines.add(s);
		}
		
		int colCount = lines.get(0).length();
		int rowCount = lines.size();
		
		Node[][] grid = new Node[rowCount][colCount];
		
		Node end = null;
		
		ArrayList<Node> starts = new ArrayList<Node>();
		
		for(int i = 0; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				int val = lines.get(i).charAt(j);
				grid[i][j] = new Node(val);
				
				if(val == 'a') {
					grid[i][j].val = 'a';
					grid[i][j].dist = 0;
					starts.add(grid[i][j]);
				}
				else if(val == 'E') {
					grid[i][j].val = 'z';
					end = grid[i][j];
				}
			}
		}
		
		
		for(int i = 0; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				
				Node n = grid[i][j];
				
				// UP
				if(i-1 >= 0) {
					int upDiff = grid[i-1][j].val - n.val;
					if(upDiff <= 1) {
						n.neighbors.add(grid[i-1][j]);
					}
				}
				
				// RIGHT
				if(j+1 < colCount) {
					int rightDiff = grid[i][j+1].val - n.val;
					if(rightDiff <= 1) {
						n.neighbors.add(grid[i][j+1]);
					}
				}
				
				// DOWN
				if(i+1 < rowCount) {
					int downDiff = grid[i+1][j].val - n.val;
					if(downDiff <= 1) {
						n.neighbors.add(grid[i+1][j]);
					}
				}
				
				// LEFT
				if(j-1 >= 0) {
					int leftDiff = grid[i][j-1].val - n.val;
					if(leftDiff <= 1) {
						n.neighbors.add(grid[i][j-1]);
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(Node start : starts) {
			
			Queue<Node> queue = new LinkedList<Node>();
			start.dist = 0;
			queue.add(start);
			
			while(!queue.isEmpty()) {
				
				Node n = queue.poll();
				if(n.visited) {
					continue;
				}
				
				for(int i = 0; i < n.neighbors.size(); i++) {
					Node neigh = n.neighbors.get(i);
					neigh.dist = Math.min(neigh.dist, n.dist+1);
					queue.add(neigh);
				}
				
				n.visited = true;
				
			}
			
			if(end.dist < min) {
				min = end.dist;
			}
			
			for(int i = 0; i < rowCount; i++) {
				for(int j = 0; j < colCount; j++) {
					grid[i][j].visited = false;
					grid[i][j].dist = Integer.MAX_VALUE;
				}
			}
			
			
		}
		System.out.println(min);
	}

}

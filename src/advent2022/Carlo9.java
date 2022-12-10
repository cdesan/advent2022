package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Carlo9 {
	
	public class Part1 {
			
		public static int[] moveTail(int head_x, int head_y, int tail_x, int tail_y) {
			
			int[] result = new int[2];
			
			double x_diff = head_x - tail_x;
			double y_diff = head_y - tail_y;
			
			double stay_val =  Math.pow(x_diff, 2) + Math.pow(y_diff ,2);
			
			stay_val = Math.sqrt(stay_val);
			
			
			// Same place
			if(Math.abs(x_diff) <= 1 && Math.abs(y_diff) <= 1) {
				result[0] = tail_x;
				result[1] = tail_y;
				return result;
			}
			
			
			//Same hori
			if(head_y == tail_y && head_x != tail_x) {
				
				int cur_x = tail_x;
				int cur_y = tail_y;
				
				if(head_x < tail_x) {
					cur_x--;
				}
				else {
					cur_x++;
				}
				
				result[0] = cur_x;
				result[1] = cur_y;
				return result;
			}
			
			//Same vert
			if(head_x == tail_x && head_y != tail_y) {
				int cur_x = tail_x;
				int cur_y = tail_y;
				
				if(head_y < tail_y) {
					cur_y--;
				}
				else {
					cur_y++;
				}
				
				result[0] = cur_x;
				result[1] = cur_y;
			}
			
			// diag ++
			
			if(x_diff > 0 && y_diff > 0) {
				tail_x++;
				tail_y++;
				result[0] = tail_x;
				result[1] = tail_y;
				return result;
			}
			
			// diag -+
			if(x_diff < 0 && y_diff > 0) {
				tail_x--;
				tail_y++;
				result[0] = tail_x;
				result[1] = tail_y;
				return result;
			}
			
			// diag --
			if(x_diff < 0 && y_diff < 0) {
				tail_x--;
				tail_y--;
				result[0] = tail_x;
				result[1] = tail_y;
				return result;
			}
			
			// diag +-
			if(x_diff > 0 && y_diff < 0) {
				tail_x++;
				tail_y--;
				result[0] = tail_x;
				result[1] = tail_y;
				return result;
			}
			
			
			
			return result;
		}
		
		public static class Knot{
			public int x;
			public int y;
			public Knot(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input9.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			Knot[] rope = new Knot[10];
			
			for(int i = 0; i < 10; i++) {
				rope[i] = new Knot(0,0);
			}
			
			HashSet<String> coords = new HashSet<String>();
			
			while(scanner.hasNextLine()) {
				
				String s = scanner.nextLine();
				
				String[] vals = s.split(" ");
				
				char dir = vals[0].charAt(0);
				
				int dist = Integer.parseInt(vals[1]);	
				
				switch(dir) {
					case 'R':
						for(int i = 0; i < dist; i++) {
							rope[0].x++;
							for(int j = 1; j < 10; j++) {
								int[] newTail = moveTail(rope[j-1].x ,rope[j-1].y, rope[j].x, rope[j].y);
								rope[j].x = newTail[0];
								rope[j].y = newTail[1];
							}
							coords.add(rope[9].x + "_" + rope[9].y);
						}
						break;
					case 'U':
						for(int i = 0; i < dist; i++) {
							rope[0].y++;
							for(int j = 1; j < 10; j++) {
								int[] newTail = moveTail(rope[j-1].x ,rope[j-1].y, rope[j].x, rope[j].y);
								rope[j].x = newTail[0];
								rope[j].y = newTail[1];
							}
							coords.add(rope[9].x + "_" + rope[9].y);
						}
						break;
					case 'L':
						for(int i = 0; i < dist; i++) {
							rope[0].x--;
							for(int j = 1; j < 10; j++) {
								int[] newTail = moveTail(rope[j-1].x ,rope[j-1].y, rope[j].x, rope[j].y);
								rope[j].x = newTail[0];
								rope[j].y = newTail[1];
							}
							coords.add(rope[9].x + "_" + rope[9].y);
						}
						break;
					case 'D':
						for(int i = 0; i < dist; i++) {
							rope[0].y--;
							for(int j = 1; j < 10; j++) {
								int[] newTail = moveTail(rope[j-1].x ,rope[j-1].y, rope[j].x, rope[j].y);
								rope[j].x = newTail[0];
								rope[j].y = newTail[1];
							}
							coords.add(rope[9].x + "_" + rope[9].y);
						}
						break;
				}

			}
			
			System.out.println(coords.size());
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Part1.Solve();

	}

}

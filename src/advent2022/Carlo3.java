package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo3 {
	
	public class Part1 {
		
		public static void Solve() throws FileNotFoundException {
			String file_path = "input3.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			int sum = 0;
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				
				int halfLength = line.length() >> 1;
				
				boolean[] compartmentOne = new boolean[53];
				
				for(int i = 0; i < halfLength; i++) {
					int val = line.charAt(i);
					if(val < 91) {
						val -= 38;
					}
					else {
						val -= 96;
					}
					compartmentOne[val] = true;
				}
				
				for(int i = halfLength; i < (halfLength << 1); i++) {
					int val = line.charAt(i);
					int prior = val;
					if(val < 91) {
						prior -= 38;
					}
					else {
						prior -= 96;
					}
					
					if(compartmentOne[prior]) {
						sum += prior;
						break;
					}
				}
				
			}
			System.out.println(sum);
		}
	}
	
	public class Part2{
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input3.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			int sum = 0;
			int lineNo = 0;
			
			boolean[][] packs = {new boolean[53],new boolean[53],new boolean[53]};
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				int length = line.length();
				
				for(int i = 0; i < length; i++) {
					int val = line.charAt(i);
					int prior = val;
					if(val < 91) {
						prior -= 38;
					}
					else {
						prior -= 96;
					}
					packs[lineNo][prior] = true;
					
					if(lineNo == 2 && (packs[0][prior] && packs[1][prior] && packs[2][prior])) {
						sum += prior;
						break;
					}
				}
				

				lineNo++;
				
				if(lineNo == 3) {
					// reset
					lineNo = 0;
					packs[0] = new boolean[53];
					packs[1] = new boolean[53];
					packs[2] = new boolean[53];
				}
				
			}
			System.out.println(sum);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Part2.Solve();
	}

}

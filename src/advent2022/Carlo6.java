package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo6 {
	
	public class Part1 {
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input6.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			String s = scanner.nextLine();
			
			int block_size = 14;
			
			int length = s.length();
			
			int[] seen = new int[26];
			
			int lastSeen = -1;
			
			for(int i = 0; i < block_size; i++) {
				int c = s.charAt(i) - 97;
				if(i == 0) {
					lastSeen = c;
				}
				seen[c]++;
				
			}
			
			for(int i = block_size; i < length; i++) {
				
				seen[lastSeen]--;
				lastSeen = s.charAt(i-(block_size-1))-97;
				
				boolean is_unique = true;

				int c = s.charAt(i) - 97;
				seen[c]++;
				
				if(seen[c] > 1) {
					is_unique = false;
				}
				
				if(is_unique) {
					boolean found = true;
					for(int j = 0; j < 26; j++) {
						found = found && seen[j] <= 1;
						if(!found) {
							break;
						}
					}
					if(found) {
						System.out.println(i+1);
						break;
					}
				}
				
			}
		}
	}
	
	public class Part2 {
		
		public static void Solve() throws FileNotFoundException {
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Part1.Solve();
	}

}

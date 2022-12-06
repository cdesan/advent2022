package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import advent2022.Carlo6.Part1;

public class Carlo6Old {
	
	public class Part1 {
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input6.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			String s = scanner.nextLine();
			
			int block_size = 14;
			
			int length = s.length();
			
			int[] seen = new int[26];
			
			for(int i = 0; i < length - block_size - 1; i++) {
								
				boolean is_unique = true;
				
				for(int j = 0; j < block_size; j++) {
					int c = s.charAt(i+j) - 97;
					seen[c]++;
					if(seen[c] > 1) {
						is_unique = false;
						break;
					}
				}
				
				if(!is_unique) {
					for(int j = 0; j < 26; j++) {
						seen[j] = 0;
					}
					continue;
				}
				
				else {
					System.out.println(i+block_size);
					break;
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
		long startTime = System.nanoTime();
		Part1.Solve();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println("Time: " + duration);
	}

}
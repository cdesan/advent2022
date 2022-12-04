package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo4 {
	
	public class Part1 {
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input4.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			int sum = 0;
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String[] ranges = line.split(",");
				
				int[] pairOne = new int[2];
				int[] pairTwo = new int[2];
				
				String[] nums = ranges[0].split("-");
				
				pairOne[0] = Integer.parseInt(nums[0]);
				pairOne[1] = Integer.parseInt(nums[1]);
				
				nums = ranges[1].split("-");
				
				pairTwo[0] = Integer.parseInt(nums[0]);
				pairTwo[1] = Integer.parseInt(nums[1]);
				
				
				if(pairOne[0] >= pairTwo[0] && pairOne[1] <= pairTwo[1]) {
					sum += 1;
				}
				else if(pairTwo[0] >= pairOne[0] && pairTwo[1] <= pairOne[1]) {
					sum += 1;
				}
				
			}
			
			System.out.println(sum);
		}
		
	}
	
	public class Part2 {
		
		public static void Solve() throws FileNotFoundException {
			String file_path = "input4.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			int sum = 0;
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String[] numsStr = line.split("[,-]");
								
				
				int num0 = Integer.parseInt(numsStr[0]);
				int num1 = Integer.parseInt(numsStr[1]);			
				int num2 = Integer.parseInt(numsStr[2]);
				int num3 = Integer.parseInt(numsStr[3]);
				
				
				if(num0 >= num2 && num0 <= num3) {
					sum += 1;
				}
				else if(num2 >= num0 && num2 <= num1) {
					sum += 1;
				}
				
			}
			
			System.out.println(sum);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Part2.Solve();

	}

}

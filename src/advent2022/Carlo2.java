package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String filePath = "input2.txt";
		
		
		Scanner scanner = new Scanner(new File(filePath));
		int totalScore = 0;
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			int valOne = line.charAt(0)-64;
			int valTwo = line.charAt(2)-87;
			
			
			if(valTwo == 1) {
				if(valOne == 1) {
					totalScore += 3;
				}
				else {
					totalScore += (valOne - 1);
				}
			}
			else if(valTwo == 2) {
				totalScore += (valOne + 3);
				
			}
			else if(valTwo == 3) {
				if(valOne == 3) {
					totalScore += 7;
				}
				else {
					totalScore += (valOne+7);
				}
				
			}
									
		}
		
		System.out.println(totalScore);
	}

}

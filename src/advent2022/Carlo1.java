package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Carlo1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String filePath = "input1_1.txt";
		
		ArrayList<Integer> elves = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(new File(filePath));
		int curElf = 0;
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if(line.length() == 0) {
				elves.add(curElf);
				curElf = 0;
			}
			else {
				curElf = curElf + Integer.parseInt(line);
			}
			
		}
		elves.add(curElf);
		elves.sort(null);
		int l = elves.size();
		int result = elves.get(l-1) + elves.get(l-2) + elves.get(l-3);
		
		System.out.println(result);

	}

}

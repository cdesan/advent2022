package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carlo10 {
	
	public static void draw(char[][] disp, int cycle, int val) {
		
		int draw_row = (cycle-1)/40;
		int draw_col = (cycle-1) % 40;
				
		int diff = Math.abs(draw_col - val);
		
		if(diff <= 1) {
			disp[draw_row][draw_col] = '#';
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String file_path = "input10.txt";
		
		Scanner scanner = new Scanner(new File(file_path));
		
		
		int cycle_no = 1;
		int reg = 1;
		
		boolean add_op = false;
		int v = 0;
		
		int result = 0;
		
		char[][] disp = new char[6][40];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 40; j++) {
				disp[i][j] = ' ';
			}
		}
		
		while(scanner.hasNextLine()) {
			//System.out.println("Start of " + cycle_no + " : " + reg);
			draw(disp, cycle_no, reg);
			if(add_op) {
				reg += v;
				cycle_no++;
				add_op = false;
				continue;
			}
			
			String s = scanner.nextLine();
			String[] vals = s.split(" ");
			if(vals[0].equals("noop")) {
				add_op = false;
			}
			else {
				v = Integer.parseInt(vals[1]);
				add_op = true;
			}
			
			
			cycle_no++;
		}
		
		if(add_op) {
			draw(disp, cycle_no, reg);
			reg += v;
			cycle_no++;
			add_op = false;
		}
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 40; j++) {
				System.out.print(disp[i][j]);
			}
			System.out.println();
		}


	}

}

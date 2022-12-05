package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Carlo5 {
	
	public class Part1{
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input5.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			String firstLine = scanner.nextLine();
			
			int length = firstLine.length();
			
			int stackCount = length / 4 + 1;
			
			ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
			
			for(int i = 0; i < stackCount; i++) {
				stacks.add(new Stack<Character>());
				int lineIndex = 4 * i + 1;
				char c = firstLine.charAt(lineIndex);
				if(c != ' ') {
					stacks.get(i).add(c);
				}
			}
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				if(s.charAt(1) == '1') {
					scanner.nextLine();
					break;
				}
				
				for(int i = 0; i < stackCount; i++) {
					int lineIndex = 4 * i + 1;
					char c = s.charAt(lineIndex);
					if(c != ' ') {
						stacks.get(i).add(0,c);
					}
				}
				
			}
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				String[] vals = s.split(" ");
				
				int count = Integer.parseInt(vals[1]);
				
				int sourceStack = Integer.parseInt(vals[3])-1;
				int destStack = Integer.parseInt(vals[5])-1;
				
				for(int i = 0; i < count; i++) {
					char c = stacks.get(sourceStack).pop();
					stacks.get(destStack).add(c);
				}
			}
			
			for(int i = 0; i < stacks.size(); i++) {
				if(stacks.get(i).size() > 0) {
					System.out.print(stacks.get(i).pop());
				}
			}
		}
	}
	
	public class Part2{
		public static void Solve() throws FileNotFoundException {
			String file_path = "input5.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			String firstLine = scanner.nextLine();
			
			int length = firstLine.length();
			
			int stackCount = length / 4 + 1;
			
			ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
			
			for(int i = 0; i < stackCount; i++) {
				stacks.add(new Stack<Character>());
				int lineIndex = 4 * i + 1;
				char c = firstLine.charAt(lineIndex);
				if(c != ' ') {
					stacks.get(i).add(c);
				}
			}
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				if(s.charAt(1) == '1') {
					scanner.nextLine();
					break;
				}
				
				for(int i = 0; i < stackCount; i++) {
					int lineIndex = 4 * i + 1;
					char c = s.charAt(lineIndex);
					if(c != ' ') {
						stacks.get(i).add(0,c);
					}
				}
				
			}
			
			Stack<Character> tmp = new Stack<Character>();
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				String[] vals = s.split(" ");
				
				int count = Integer.parseInt(vals[1]);
				
				int sourceStack = Integer.parseInt(vals[3])-1;
				int destStack = Integer.parseInt(vals[5])-1;
				
				
				for(int i = 0; i < count; i++) {
					tmp.add(stacks.get(sourceStack).pop());
					
				}
				while(!tmp.isEmpty()) {
					stacks.get(destStack).add(tmp.pop());
				}
			}
			
			for(int i = 0; i < stackCount; i++) {
				if(stacks.get(i).size() > 0) {
					System.out.print(stacks.get(i).pop());
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Part2.Solve();
	}

}

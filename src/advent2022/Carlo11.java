package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Carlo11 {
	
	public static class Monkey {
		
		public Queue<Long> items;
		public long inspectionCount;
		
		public char op;
		public long opVal;
		
		public long testVal;
		
		public int testOut1;
		public int testOut2;
		
		
		public Monkey() {
			this.items = new LinkedList<Long>();
			inspectionCount = 0;
		}
		
		public void addItem(long i) {
			this.items.add(i);
		}
		
		public long inspect() {
			
			long item = this.items.poll();
			this.inspectionCount++;
			long newWorry = this.doOp(item);
			return newWorry;
			
		}
		
		private long doOp(long item) {
			long v;
			if(this.opVal == -1) {
				v = item;
			}
			else {
				v = this.opVal;
			}
			
			switch(this.op) {
			case '*':
				return item * v;
			case '+':
				return item + v;
			}
			System.out.println("This should not print");
			return 0;
		}
		
		private int doTest(long item) {
			if(item % this.testVal == 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		
		
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String file_path = "input11.txt";
		
		Scanner scanner = new Scanner(new File(file_path));
		
		ArrayList<Monkey> monks = new ArrayList<Monkey>();
		
		long lcm = 1;
		
		while(scanner.hasNextLine()) {
			String s = scanner.nextLine();
			
			String[] vals = s.split(" ");
			
			if(vals[0].equals("Monkey")) {
				
				Monkey m = new Monkey();
				
				
				String starting = scanner.nextLine();
				
				String[] startingVals = starting.split("[\\s+,]");
				for(int i = 4; i < startingVals.length; i++) {
					if(startingVals[i].length() > 0) {
						m.addItem((long)Integer.parseInt(startingVals[i]));
					}
				}
				
				String op = scanner.nextLine();
				String[] opVals = op.split("[\\s]");
				
				char opAction = opVals[6].charAt(0);
				long opVal;
				try {
					opVal = Integer.parseInt(opVals[7]);
				}
				catch(Exception e) {
					opVal = -1;
				}
				m.op = opAction;
				m.opVal = opVal;
				
				String test = scanner.nextLine();
				
				String[] testVals = test.split("\\s+");
								
				m.testVal = (long)Integer.parseInt(testVals[4]); 
				lcm *= m.testVal;
				String testOut1 = scanner.nextLine();
				int out1 = Integer.parseInt(testOut1.split(" ")[9]);
				String testOut2 = scanner.nextLine();
				int out2 = Integer.parseInt(testOut2.split(" ")[9]);
				
				m.testOut1 = out1;
				m.testOut2 = out2;
				
				monks.add(m);
			
			}
			
		}
		int turn_count = 10000;
		for(int i = 0; i < turn_count; i++) {
			//System.out.println(i+1);
			for(Monkey m : monks) {
				while(!m.items.isEmpty()) {
					long v = m.inspect();
					int received = m.doTest(v);
					if(received == 0) {
						long vv = v % (lcm);
						monks.get(m.testOut1).addItem(vv);
					}
					else {
						long vv = v % (lcm);
						monks.get(m.testOut2).addItem(vv);

					}
				}
			}
			
		}
		
		long max1 = -1;
		long max2 = -1;
		for(Monkey m : monks) {
			long i = m.inspectionCount;
			//System.out.println(i);
			if(i > max1) {
				max2 = max1;
				max1 = i;
			}
			else if(i > max2 && i < max1) {
				max2 = i;
			}
		
		}
		System.out.println(max1*max2);
	}

}

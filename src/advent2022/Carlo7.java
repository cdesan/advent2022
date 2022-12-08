package advent2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Carlo7 {
	
	public class Part1 {
		
		public static class Node {
			
			public Node parent;
			public ArrayList<Node> children;
			public String fileName;
			public int fileSize;
			public boolean isDir;
			
			public Node(Node parent, String name, int size, boolean isDir) {
				this.parent = parent;
				this.children = new ArrayList<Node>();
				this.fileName = name;
				this.fileSize = size;
				this.isDir = isDir;
			}
			
			public void addChild(Node child) {
				this.children.add(child);
			}
			
		}
		public static int calculateNodeSize(Node n, ArrayList<Node> result) {
			
			int returnVal = 0;
			if(!n.isDir) {
				returnVal = n.fileSize;
			}
			else {
				int sum = 0;
				int l = n.children.size();
				
				for(int i = 0; i < l; i++) {
					sum += calculateNodeSize(n.children.get(i), result);
				}
				returnVal = sum;
			}
			
			n.fileSize = returnVal;
			result.add(n);
			return returnVal;
		}
		
		public static void Solve() throws FileNotFoundException {
			
			String file_path = "input7.txt";
			
			Scanner scanner = new Scanner(new File(file_path));
			
			Node curDirNode = new Node(null, "/", 0, true);
			Node rootNode = curDirNode;
			
			
			int totalSize = 70000000;
			int updateSize = 30000000;
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				String[] vals = s.split(" ");
				
				if(vals[0].charAt(0) == '$') {
					//Command
					if(vals[1].equals("cd")) {
						
						//Curnode will become either the parent or one of the children
						
						String newCurName = vals[2];
						
						if(newCurName.equals("..")) {
							curDirNode = curDirNode.parent;
						}
						else if(newCurName.equals("/")) {
							curDirNode = rootNode;
						}
						else {
							int l = curDirNode.children.size();
							Node newCur = null;
							for(int i = 0; i < l; i++) {
								Node child = curDirNode.children.get(i);
								if(child.fileName.equals(newCurName)) {
									newCur = child;
									break;
								}
							}
							if(newCur == null) {
								System.out.println(s);
							}
							curDirNode = newCur;
						}
					}
				}
				else {
					//File that gets added to current file node
					
					//Either file or dir
					if(vals[0].equals("dir")) {
						String dirName = vals[1];
						Node newNode = new Node(curDirNode, dirName, 0, true);
						curDirNode.addChild(newNode);
					}
					else {
						int fileSize = Integer.parseInt(vals[0]);
						String fileName = vals[1];
						Node newNode = new Node(curDirNode, fileName, fileSize, false);
						curDirNode.addChild(newNode);
					}
				}
			}
			
			ArrayList<Node> result = new ArrayList<Node>();
			int totalUsedSpace = calculateNodeSize(rootNode, result);
			
			int unusedSpace = totalSize - totalUsedSpace;
						
			int curBest = totalSize;
			
			for(int i = result.size()-1; i >= 0; i--) {
				int fileSize = result.get(i).fileSize;
				
				if(fileSize + unusedSpace >= updateSize && fileSize < curBest) {
					curBest = fileSize;
				}
				
			}
			
			System.out.println(curBest);
			
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Part1.Solve();
	}

}

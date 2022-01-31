package com.greatlearning.Pathlength;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestPath {
Scanner in=new Scanner(System.in);
    class Node{
    	Node left;
    	Node right;
    	int data;
    }
    static Node root;
    static Node left;
    static Node right;

public Node createTree() {
    Node node=new Node();
    int data=in.nextInt();
    if(data==0) {
	 System.out.println("Reached the leaf Node");
    	return null;
    }
    else {
      if(root==null) {
    	  node.data=data;
    	  root=node;
      }
       node.data=data;	
       System.out.println("Enter left child of " + data);
       node.left=createTree();
       System.out.println("Enter the right child of " + data);
       node.right=createTree();
    }
	return node;
 }



public static ArrayList<Integer> longestpath(Node root) {
	if(root==null) {
		ArrayList<Integer>output=new ArrayList<>();
		return output;
	}
	ArrayList<Integer>right=longestpath(root.right);
	ArrayList<Integer>left=longestpath(root.left);
	
	if(right.size()<left.size()) {
		left.add(root.data);
	}
	else {
	right.add(root.data);
	}
	return(left.size() > right.size() ? left : right);
    }
    

public static void main(String[] args) {
	LongestPath tree = new LongestPath();
	System.out.println("Enter the root node");
	tree.createTree();
	ArrayList<Integer>output=longestpath(root);
	int n=output.size();
	System.out.println("longest path is");
	System.out.println(" ");
	for(int i=n-1;i>=0;i--) {
		System.out.print(output.get(i) + "--->");
	}
	System.out.println("End");
	 

}
}
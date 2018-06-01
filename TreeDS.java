package treeds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeDS {

	// 2 3 5 1 9 0 3 0 2 0
	static Scanner s = new Scanner(System.in);

	
	
	
	
	
	
	
	
	
	
	heightUsingQueue(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int count =0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.remove();
		
			if(current ==null){		
				count++;
				if(queue.isEmpty()){
					break;
				}
				queue.add(null);
				continue;
			}
			for (int i = 0; i < current.childrenlist.size(); i++) {
				queue.add(current.childrenlist.get(i));
			}
		}
		return count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	TreeNode<Integer> maxWaliNode(TreeNode<Integer> root) {
		TreeNode<Integer> maxDataNode = root;
		for (int i = 0; i < root.childrenlist.size(); i++) {
			TreeNode<Integer> currentNode = maxWaliNode(root.childrenlist
					.get(i));
			if (currentNode.data.compareTo(maxDataNode.data) > 0) {
				maxDataNode = currentNode;
			}
		}
		return maxDataNode;
	}

	
	
	int countNoOfNodesUsingQueue(TreeNode<Integer> root){
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		int count =0;
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.remove();
		
			count++;
			for (int i = 0; i < current.childrenlist.size(); i++) {
				queue.add(current.childrenlist.get(i));
			}
		}
		return count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	TreeNode<Integer> constructTreeUsingQueue() {

		Queue<TreeNode<Integer>> queue = new LinkedList<>();

		System.out.println("Enter data");
		int data = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> current = queue.remove();
			System.out.println("Enter no of Children");
			int noOfChildren = s.nextInt();
			for (int i = 0; i < noOfChildren; i++) {
				System.out.println("Enter child data");
				TreeNode<Integer> nyaNode = new TreeNode<>(s.nextInt());
				current.childrenlist.add(nyaNode);
				queue.add(nyaNode);
			}
		}
		return root;
	}

	static void printTree(TreeNode<Integer> root) {
		String tobeprinted = root.data + ": ";
		for (int i = 0; i < root.childrenlist.size(); i++) {
			tobeprinted += root.childrenlist.get(i).data + ", ";
		}
		System.out.println(tobeprinted);
		for (int i = 0; i < root.childrenlist.size(); i++) {
			printTree(root.childrenlist.get(i));
		}

	}

	static TreeNode<Integer> constructTree() {

		System.out.println("Enter data");
		int data = s.nextInt();
		TreeNode<Integer> nyaNode = new TreeNode<>(data);
		System.out.println("Enter No. of Children");
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			nyaNode.childrenlist.add(constructTree());
		}
		return nyaNode;
	}

	public static void main(String[] args) {
		// TreeNode<Integer> root = constructTree();
		// printTree(root);

		TreeNode<Integer> root = new TreeNode<>(1);
		root.childrenlist.add(new TreeNode<>(2));
		root.childrenlist.add(new TreeNode<>(3));
		root.childrenlist.add(new TreeNode<>(4));
		root.childrenlist.get(0).childrenlist.add(new TreeNode<>(5));
		root.childrenlist.get(1).childrenlist.add(new TreeNode<>(6));
		root.childrenlist.get(2).childrenlist.add(new TreeNode<>(7));

	}
}

package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5639_이진검색트리 {
	public static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int v){
			value = v;
		}
	}
	
	
	public static Node root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이진 트리 완성
		while(true){
			String s = br.readLine();
			if(s == null || s.length() == 0) break;
			int v = Integer.parseInt(s);
			
			// root 설정
			if(root == null) {
				root = new Node(v);
				continue;
			}
			
			Node node = root;
			while(true){
				if(node.value > v) {
					if(node.left != null){
						node = node.left;
						continue;
					}
					node.left = new Node(v);
					break;
				}
				if(node.value < v) {
					if(node.right != null){
						node = node.right;
						continue;
					}
					node.right = new Node(v);
					break;
				}
			}
		}
		
		// 후위 순회
		travel(root);
	}
	
	public static void travel(Node node){
		if(node.left != null) travel(node.left);
		if(node.right != null) travel(node.right);
		System.out.println(node.value);
	}
}

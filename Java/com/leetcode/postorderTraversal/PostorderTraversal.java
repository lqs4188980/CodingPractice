package com.leetcode.postorderTraversal;

import java.util.ArrayList;

public class PostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		postorderTraversal(root);
	}
	
    static TreeNodeListNode head;
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        if(root.left == null && root.right == null){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(root.val);
            return result;
        }
        
        TreeNodeListNode rootNode = new TreeNodeListNode(root, true);
        head = rootNode;
        
        if(root.right != null){
            TreeNodeListNode rightNode = new TreeNodeListNode(root.right, false);
            addToHead(rightNode);
        }
        
        if(root.left != null){
            TreeNodeListNode leftNode = new TreeNodeListNode(root.left, false);
            addToHead(leftNode);
        }
        
        
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!isEmpty()){
        	showStack();
            if(head.isRoot){
                result.add(head.node.val);
                removeHead();
                continue;
            }
            else{
                if(head.node.left == null && head.node.right == null){
                    result.add(head.node.val);
                    removeHead();
                    continue;
                }
                head.isRoot = true;
                TreeNode node = head.node;
                
                if(node.right != null){
                    addToHead(new TreeNodeListNode(node.right, false));
                }
                if(node.left != null){
                    addToHead(new TreeNodeListNode(node.left, false));
                }
                continue;
            }
        }
        
        return result;
        
    }
    
    public static void addToHead(TreeNodeListNode node){
        node.next = head;
        head = node;
    }
    
    public static void removeHead(){
        head = head.next;
    }
    
    public static boolean isEmpty(){
        return head == null ? true : false;
    }
    
    public static void showStack(){
    	System.out.println("********************************************************");
    	TreeNodeListNode node = head;
    	while(node != null){
    		System.out.println(node.node.val);
    		node = node.next;
    	}
    	System.out.println("********************************************************");
    }

}

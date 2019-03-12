package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintBinaryTree2_Dimensions {

    private Node root;

    public PrintBinaryTree2_Dimensions(Node root) {
        this.root = root;
    }


    public void printVertical(){
        printVertical(root , 0);
    }

    private void printVertical(Node node ,int level){
        if(node==null)
            return;
        else{
            printVertical(node.right ,level+1);
            printVerticalOrder(node.data , level);
            printVertical(node.left ,level+1);
        }
    }

    private void printVerticalOrder(int data, int spaces){
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<spaces;i++)
            stringBuffer.append(" ");
        stringBuffer.append(data);
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        PrintBinaryTree2_Dimensions tree2_dimensions =new PrintBinaryTree2_Dimensions(root);
        tree2_dimensions.printVertical();
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}

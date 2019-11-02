package com.amazon.question;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeNTree {

    private Node node;

    private StringBuilder builder;

    private int i=0;
    public SerializeDeserializeNTree(Node node) {
        this.node = node;
        this.builder=new StringBuilder("");
    }

    public String serialize(){
        builder.delete(0, builder.length());
        System.out.println(builder.toString());
        serialize(node);
        return builder.toString();
    }

    private void serialize(Node node ){
        if(node==null){
            return ;
        }else{
            builder.append(node.data);
            for(Node node1 : node.nodeList){
                serialize(node1);
            }
            builder.append(")");
        }
    }

    public Node deserialize(){
        Node n= deserialize(builder.toString());
        System.out.println(serialize());
        return n;
    }

    private Node deserialize(String str){
        if(str.charAt(i)==')')
            return null;
        else{
            Node n =new Node(new String(new char[]{str.charAt(i)}));
            i++;
            while(i<str.length()){
                Node n1 =deserialize(str);
                if(n1!=null){
                    n.nodeList.add(n1);
                }else{
                    break;
                }
            }
            return n;
        }
    }

    public static void main(String[] args) {
        Node node =new Node("A");Node node1 =new Node("B");node.nodeList.add(node1);
        node1.nodeList.add(new Node("E"));Node node2 =new Node("F");node2.nodeList.add(new Node("K"));node1.nodeList.add(node2);
        node.nodeList.add(new Node("C"));Node node3 =new Node("D");
        node3.nodeList.add(new Node("G"));node3.nodeList.add(new Node("H"));node3.nodeList.add(new Node("I"));node3.nodeList.add(new Node("J"));node.nodeList.add(node3);
        SerializeDeserializeNTree nTree =new SerializeDeserializeNTree(node);
        System.out.println(nTree.serialize());
        nTree.deserialize();
    }

    static class Node{
        String data;
        List<Node> nodeList =new ArrayList<>();
        public Node(String data) {
            this.data = data;
        }
    }
}

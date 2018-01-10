package com.wellsfargo.data_structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<K> extends AbstractTree<K> {

    protected Entry<K> root;

    @Override
    public K add(K key) {
        if(!(key instanceof Comparable))
            throw new RuntimeException("NotCompartable Interface");
        if(root==null){
            root=new Entry<>(key);
            root.setParent(root);
            return key;
        }
        Entry<K> entry =root , lastNode=root;
        int compValue =0;
        while(entry!=null){
            lastNode =entry;
            if((compValue =compare(entry.getKey() , key ))>0)
                entry =entry.getLeft();
            else
                entry =entry.getRight();
        }
        Entry<K> kEntry=new Entry<>(key ,lastNode);
        if(compValue>0)
            lastNode.setLeft(kEntry);
        else
            lastNode.setRight(kEntry);
        return key;
    }

    private final int compare (K newEle , K root){
        return ((Comparable)newEle).compareTo(root);
    }

    private int getHeight(Entry<K> entry ){
        if(entry ==null)
            return  0 ;
        else{
            int l = 1+ getHeight(entry.getLeft());
            int r = 1+ getHeight(entry.getRight());
            return Math.max(l , r);
        }
    }


    public int height(){
        return  getHeight(root);
    }

    /*
    *  Level Order Traversal Start
    *
    */
    public void levelOrderTraversalUsingRecursion(){
        for(int i=0;i<getHeight(root);i++)
            printLevelOrderTra(root , i);
    }

    private void printLevelOrderTra(Entry<K> kEntry , int i){
        if(i==0 && kEntry!=null)
        {
            System.out.println(kEntry.getKey());
        }else if(i>0){
            printLevelOrderTra(kEntry.getLeft() , i-1);
            printLevelOrderTra(kEntry.getRight() , i-1);
        }
    }

    public void levelOrderTraversalUsingIterative(){
        Queue<Entry> entryQueue=new LinkedBlockingQueue<>();
        entryQueue.add(root);
        while(entryQueue.size()>0){
            Entry<K> entry = entryQueue.poll();
            System.out.println(entry.getKey());
            if(entry.getLeft()!=null)
                entryQueue.add(entry.getLeft());
            if(entry.getRight()!=null)
                entryQueue.add(entry.getRight());
        }
    }

    public void levelOrderTraversalUsingZigZak(){
        Queue<Entry<K>> entries =new ArrayDeque<>();
        entries.add(root);
        while(entries.size()>0){
            int size= entries.size();
            while(size>0){
                Entry<K> kEntry =entries.poll();
                System.out.print(kEntry.getKey()+" ");
                if(kEntry.getLeft()!=null)
                    entries.add(kEntry.getLeft());
                if(kEntry.getRight()!=null)
                    entries.add(kEntry.getRight());
                size--;
            }
            System.out.println();
        }
    }

    public void levelOrderByTwoQueue(){
        Queue<Entry<K>> queue1 =new ArrayDeque<>();
        Queue<Entry<K>> queue2 =new ArrayDeque<>();
        queue1.add(root);

        while(queue1.size()>0 || queue2.size()>0){

            while (queue1.size()>0){
                Entry<K> kEntry =queue1.poll();
                System.out.print(kEntry.getKey()+"");
                if(kEntry.getLeft()!=null)
                    queue2.add(kEntry.getLeft());
                if(kEntry.getRight()!=null)
                    queue2.add(kEntry.getRight());
            }
            System.out.println();
            while (queue2.size()>0){
                Entry<K> kEntry =queue2.poll();
                System.out.print(kEntry.getKey()+"");
                if(kEntry.getLeft()!=null)
                    queue1.add(kEntry.getLeft());
                if(kEntry.getRight()!=null)
                    queue1.add(kEntry.getRight());
            }
            System.out.println();
        }

    }

    public void perfectLevelOrderTraversal(){
        Queue<Entry<K>> queue1 =new ArrayDeque<>();
        System.out.print(root.getKey()+" ");
        queue1.add(root.getLeft());queue1.add(root.getRight());
        while(queue1.size()>0){
            Entry<K> entry1 = queue1.poll();
            Entry<K> entry2 = queue1.poll();
            System.out.print(entry1.getKey()+" ");
            System.out.print(entry2.getKey()+" ");
            if(entry1.getLeft()!=null)
                queue1.add(entry1.getLeft());
            if(entry2.getRight()!=null)
                queue1.add(entry2.getRight());
            if(entry1.getRight()!=null)
                queue1.add(entry1.getRight());
            if(entry2.getLeft()!=null)
                queue1.add(entry2.getLeft());
        }
    }
    /*
     *  Level Order Traversal End
     *
     */

    /*
     *  In Order Traversal Start
     *
     */

    public void inOrderTraversalIterative(){
        Stack<Entry<K>> stack =new Stack<>();
        stack.push(root);
        Entry<K> kEntry =root;
        while(stack.size()>0){
            while(kEntry.getLeft()!=null){
                stack.push(kEntry.getLeft());
                kEntry = kEntry.getLeft();
            }
            kEntry =stack.pop();
            System.out.println(kEntry.getKey());
            if(kEntry.getRight()!=null){
                stack.push(kEntry.getRight());
                kEntry =kEntry.getRight();
            }
        }
    }

    public void inOrderTraversalRecursion(){
        inOrderRecur(root);
    }

    private void inOrderRecur(Entry<K> entry){
        if(entry!=null){
            inOrderRecur(entry.getLeft());
            System.out.println(entry.getKey());
            inOrderRecur(entry.getRight());
        }
    }


    /*
     *  In Order Traversal End
     *
     */

    /*
     *  Pre Order Traversal Start
     *
     */

    /*
     *  Pre Order Traversal End
     *
     */

    public static void main(String[] args) {
        Tree<Integer> tree=new BinarySearchTree<>();
        tree.add(20);tree.add(10);tree.add(40);
        tree.add(5);tree.add(17);tree.add(30);tree.add(45);
       ((BinarySearchTree)tree).inOrderTraversalIterative();
        //System.out.println(tree.height());
    }
}

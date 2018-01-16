package com.wellsfargo.data_structure.tree;

import java.util.*;
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

    public void diagonalTraversal(){
        Map<Integer ,List<Entry<K>>> entryMap=new HashMap<>();

        for(Map.Entry<Integer , List<Entry<K>>> integerListEntry: diagonalTra(root , 0 , entryMap).entrySet()){
            System.out.print(integerListEntry.getKey() +" ");
            for(Entry<K> kEntry :integerListEntry.getValue())
            {
                System.out.print(kEntry.getKey() +" ");
            }
            System.out.println();
        }
    }

    private Map<Integer , List<Entry<K>>> diagonalTra(Entry<K> entry , int d ,Map<Integer , List<Entry<K>>> entryMap){
        List<Entry<K>>  entryMapList =entryMap.get(d);

        if(entryMapList==null)
            entryMapList=new ArrayList<>();

        entryMapList.add(entry);

        entryMap.put(d,entryMapList );
        if(entry.getLeft()!=null)
            diagonalTra(entry.getLeft() , d+1, entryMap);

        if(entry.getRight()!=null)
            diagonalTra(entry.getRight() , d, entryMap);
        return  entryMap;
    }

    /*
    *
    * Print a Binary Tree in Vertical Order Start
    *
    * */
    public void verticalTraversal(){
        int min =0 ;int max= 0;
        getMinMaxDepthBinaryTree(root , max ,min , 0);
        System.out.println(1);
    }

    private void getMinMaxDepthBinaryTree(Entry<K> entry , int max , int min , int currwidth){
        if(currwidth>max)
            max= currwidth ;
        if(currwidth<min)
            min =currwidth;
        if(entry.getLeft()!=null){
            getMinMaxDepthBinaryTree(entry.getLeft() , max ,min , currwidth-1);
        }
         if(entry.getRight()!=null){
            getMinMaxDepthBinaryTree(entry.getRight() , max ,min , currwidth+1);
        }
    }
    /*
     *
     * Print a Binary Tree in Vertical Order End
     *
     * */

    /*
    *
    * Boundary Traversal of binary tree Start
    *
    * */
    public void boundaryTraversal(){
        System.out.println(root.getKey());
        leftAndRightBoundryTrasal(root.getLeft() , true);
        leafTraversal(root);
        leftAndRightBoundryTrasal(root.getRight() , false);
    }

    private void leafTraversal(Entry<K> entry){
        if(entry.getLeft()==null && entry.getRight()==null)
            System.out.println(entry.getKey());
        else
        {
            if(entry.getLeft()!=null)
                leafTraversal(entry.getLeft());
            if(entry.getRight()!=null)
                leafTraversal(entry.getRight());
        }
    }

    private void leftAndRightBoundryTrasal(Entry<K> entry , boolean leftOrRight){
        if(leftOrRight && entry.getLeft()!=null ){
            System.out.println(entry.getKey());
            leftAndRightBoundryTrasal(entry.getLeft() , leftOrRight);
        }else if(entry.getRight()!=null)
        {
            System.out.println(entry.getKey());
            leftAndRightBoundryTrasal(entry.getRight() , leftOrRight);
        }
    }
    /*
     *
     * Boundary Traversal of binary tree End
     *
     * */


    /*
     *
     * LCA Question Starts
     *
     * */
    public K getLCA(K k1 , K k2){
        Entry<K> kEntry =getLCA(root , k1, k2);
        return kEntry==null ? null : kEntry.getKey();
    }

    private Entry<K> getLCA(Entry<K> entry , K k1 , K k2){
        if(entry==null)
            return  null;
        if(entry.getKey().equals(k1) || entry.getKey().equals(k2))
            return entry;

        Entry<K> entryLeft = getLCA(entry.getLeft() , k1,k2);
        Entry<K> entryRight = getLCA(entry.getRight() , k1,k2);

        if(entryLeft!=null && entryRight!=null)
            return entry;

        return entryLeft==null ? entryRight : entryRight;
    }
    /*
     *
     * LCA Question End
     *
     * */

    public static void main(String[] args) {
        Tree<Integer> tree=new BinarySearchTree<>();
        tree.add(20);
            tree.add(8);tree.add(22);
        tree.add(4);tree.add(12);tree.add(10);
        tree.add(14);tree.add(21);tree.add(25);
        System.out.println(((BinarySearchTree)tree).getLCA(21,29));
        //System.out.println(tree.height());
    }
}

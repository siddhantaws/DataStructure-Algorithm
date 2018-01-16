package com.wellsfargo.data_structure.tree;

public class ThreadedBinaryTree<K> extends BinarySearchTree {

    public void inOrderTraversal(){
        Entry<K> current= root;
        while(current.getRight()!=null){
            while(current.getLeft()!=null){
                Entry<K> kEntry =getPreOrderSuccessor(current);
                if(kEntry.getKey().equals(current.getKey())) {
                    System.out.println(current.getKey());
                    current=current.getRight();
                }else{
                    kEntry.setRight(current);
                    current=current.getLeft();
                }
            }
            System.out.println(current.getKey());
            if(current.getRight()!=null)
                current=current.getRight();
        }
    }

    public void preOrderTraversal(){
        Entry<K> current =root;
        while(current.getRight()!=null){
            while(current.getLeft()!=null){
                System.out.println(current.getKey());
                Entry<K> kEntry =getPreOrderSuccessor(current);
                if(kEntry.getKey().equals(current.getKey())) {
                    current=current.getRight();
                }else{
                    kEntry.setRight(current);
                    current=current.getLeft();
                }
            }
            if(current.getRight()!=null)
                current=current.getRight();
            System.out.println(current.getKey());
        }
    }

    private Entry<K> getPreOrderSuccessor(Entry<K> entry){
        Entry<K> kEntry =entry.getLeft();
        while(kEntry.getRight()!=null){
            if(kEntry.getKey().equals(entry.getKey()))
                return entry;
            kEntry =kEntry.getRight();
        }
        return kEntry;
    }

    public static void main(String[] args) {
        Tree<Integer> tree=new ThreadedBinaryTree<>();
        tree.add(20);tree.add(10);tree.add(40);
        tree.add(5);tree.add(17);tree.add(30);tree.add(45);
        ((ThreadedBinaryTree)tree).preOrderTraversal();
    }

}

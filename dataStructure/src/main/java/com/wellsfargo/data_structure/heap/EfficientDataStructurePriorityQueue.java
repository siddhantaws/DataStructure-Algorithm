package com.wellsfargo.data_structure.heap;

import java.util.Comparator;

public class EfficientDataStructurePriorityQueue<E extends  Comparable>   {

    private int capacity;

    private  PriorityQueue minHeap;

    private PriorityQueue maxHeap;

    private Node head;

    public EfficientDataStructurePriorityQueue(int capacity) {
        this.capacity = capacity;
        this.minHeap =new PriorityQueue(capacity);
        this.maxHeap =new PriorityQueue(capacity,(Node o1, Node o2)-> o2.e.compareTo(o1.e));
    }

    public E add(E e){
        //Add in to linkedList
        Node n = addInLinkedList(e);
        n.minHeapIndex = minHeap.add(n);
        n.maxHeapIndex = maxHeap.add(n);
        return e;
    }

    public E getMax(){
        return maxHeap.peek();
    }

    public E getMin(){
        return minHeap.peek();
    }


    public void deleteMax(){

    }

    private Node addInLinkedList(E e){
        Node n =createNode(e);
        if(head==null){
            head=n;
        }else{
            n.next=head;
            head.prev=n;
            head=n;
        }
        return n;
    }

    class PriorityQueue {
        private Object[] arr;

        private int capacity;

        private int size;

        private Comparator<Node> nodeComparator;

        public PriorityQueue(int capacity) {
            this(capacity, null);
        }

        public PriorityQueue(int capacity, Comparator<Node> nodeComparator) {
            this.capacity = capacity;
            this.nodeComparator = nodeComparator;
        }

        public E peek(){
            return (E)arr[0];
        }

        public int add(Node node) {
            if (size == capacity) {
                Object[] minHeapNew = new Object[capacity << 1];
                System.arraycopy(arr, 0, minHeapNew, 0, arr.length);
                this.arr = minHeapNew;
            }
                size++;
                return  moveUp(node, size - 1);
        }

        private int moveUp(Node node, int index) {
            if (nodeComparator != null)
                return moveUpUsingComparator(node, index);
            else
                return moveUpUsingComparable(node, index);
        }

        private int moveUpUsingComparator(Node node, int index) {
            int k = index;
            while (k != 0) {
                int parent = k >> 1;
                Node np = (Node) arr[parent];
                if (nodeComparator.compare(node, np) < 0) {
                    arr[index] = np;
                    k = parent;
                } else {
                    break;
                }
            }
            arr[k] = node;
            return k;
        }

        private int moveUpUsingComparable(Node node, int index) {
            int k = index;
            while (k != 0) {
                int parent = k >> 1;
                Node np = (Node) arr[parent];
                if (np.e.compareTo(node.e) > 0) {
                    arr[index] = np;
                    k = parent;
                } else {
                    break;
                }
            }
            arr[k] = node;
            return k;
        }
    }

    private Node createNode(E e){
        return new Node(e);
    }

    class Node<E extends  Comparable>  {
        E e;
        Node next;
        Node prev;
        int minHeapIndex=-1;
        int maxHeapIndex=-1;
        public Node(E e) {
            this.e = e;
        }
    }
}

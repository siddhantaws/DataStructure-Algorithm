package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LinkedCompleteBinaryTreeItsCreation {

    private  Node root;
    class Node {// A tree node
        int data;
        Node right,left;
        public Node(int data) {
            this.data = data;
        }
    }

    class Queue {// A queue node
        int front, rear;
        int size;
        Node array[];
    }

    Node newNode(int data) {// A utility function to create a new tree node
        Node temp = new Node(data);
        return temp;
    }

    Queue createQueue(int size) {// A utility function to create a new Queue
        Queue queue = new Queue();

        queue.front = queue.rear = -1;
        queue.size = size;
        queue.array = new Node[queue.size ];
        int i;
        for (i = 0; i < size; ++i)
            queue.array[i] = null;
        return queue;
    }

    boolean isEmpty(Queue queue) {// Standard Queue Functions
        return queue.front == -1;
    }
    boolean isFull(Queue queue) {
        return queue.rear == queue.size - 1;
    }

    boolean hasOnlyOneItem(Queue queue) {
        return queue.front == queue.rear;
    }

    void Enqueue(Node root, Queue queue) {
        if (isFull(queue))
            return;

        queue.array[++queue.rear] = root;
        if (isEmpty(queue))
            ++queue.front;
    }

    Node Dequeue(Queue queue) {
        if (isEmpty(queue))
            return null;

        Node temp = queue.array[queue.front];

        if (hasOnlyOneItem(queue))
            queue.front = queue.rear = -1;
        else
            ++queue.front;
        return temp;
    }

    Node getFront(Queue queue) {
        return queue.array[queue.front];
    }

    // A utility function to check if a tree node has both left and right children
    boolean hasBothChild(Node temp)
    {
        return temp!=null && temp.left!=null  && temp.right!=null;
    }
    // Function to insert a new node in complete binary tree
    void insert(int data, Queue queue) {
        // Create a new node for given data
        Node temp = newNode(data);

        // If the tree is empty, initialize the root with new node.
        if (root==null)
        root = temp;

    else
        {
            // get the front node of the queue.
            Node front = getFront(queue);

            // If the left child of this front node doesn’t exist, set the
            // left child as the new node
            if (front.left==null)
                front.left = temp;

                // If the right child of this front node doesn’t exist, set the
                // right child as the new node
            else if (front.right==null)
                front.right = temp;

            // If the front node has both the left child and right child,
            // Dequeue() it.
            if (hasBothChild(front))
                Dequeue(queue);
        }

        // Enqueue() the new node for later insertions
        Enqueue(temp, queue);
    }
}

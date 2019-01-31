package com.wellsfargo.data_structure.queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class EfficientlyImplementKQueuesInSingleArray {
    private int arr[] ;   // Array of size n to store actual content to be stored in queue
    private int front[];   // Array of size k to store indexes of front elements of queue
    private int rear[];   // Array of size k to store indexes of rear elements of queue
    private int next[];  // Array of size n to store next entry in all queues
    // and free list
    private int n, k;
    private int free; // To store beginning index of free list

    // Constructor to create k queues in an array of size n
    public EfficientlyImplementKQueuesInSingleArray(int k, int n) {
        // Initialize n and k, and allocate memory for all arrays
        this.k = k;
        this.n = n;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        // Initialize all queues as empty
        for (int i = 0; i < k; i++)
            front[i] = -1;
        // Initialize all spaces as free
        for (int i=0; i<n-1; i++)
            next[i] = i+1;
        next[n-1] = -1;  // -1 is used to indicate end of free list
    }
    // A utility function to check if there is space available
    public boolean isFull()   {  return (free == -1);  }

    // To check whether queue number 'qn' is empty or not
    public boolean isEmpty(int qn)  {  return (front[qn] == -1); }

    // To dequeue an from queue number 'qn' where qn is from 0 to k-1
    public int dequeue(int qn) {
        // Underflow checkSAS
        if (isEmpty(qn)) {
            System.out.println("\nQueue Underflow\n");
            return Integer.MAX_VALUE;
        }
        // Find index of front item in queue number 'qn'
        int i = front[qn];
        front[qn] = next[i];  // Change top to store next of previous top
        // Attach the previous front to the beginning of free list
        next[i] = free;
        free = i;
        // Return the previous front item
        return arr[i];
    }
    // To enqueue an item in queue number 'qn' where qn is from 0 to k-1
    public void enqueue(int item, int qn) {
        // Overflow check
        if (isFull()) {
            System.out.println("\nQueue Overflow\n");
            return;
        }
        int i = free;      // Store index of first free slot
        // Update index of free slot to index of next slot in free list
        free = next[i];
        if (isEmpty(qn))
            front[qn] = i;
        else
            next[rear[qn]] = i;
        next[i] = -1;
        // Update next of rear and then rear for queue number 'qn'
        rear[qn] = i;
        // Put the item in array
        arr[i] = item;
    }

    public static void main(String[] args) {
        EfficientlyImplementKQueuesInSingleArray  array =new EfficientlyImplementKQueuesInSingleArray(3,10);
        array.enqueue(15, 2);
        array.enqueue(45, 2);
        array.enqueue(17, 1);
        array.enqueue(49, 1);
        array.enqueue(39, 1);
        System.out.println("Dequeued element from queue 2 is " +array.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " +array.dequeue(1));
    }
}

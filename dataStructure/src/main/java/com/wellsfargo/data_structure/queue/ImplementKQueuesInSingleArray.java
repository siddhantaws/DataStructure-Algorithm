package com.wellsfargo.data_structure.queue;

public class ImplementKQueuesInSingleArray {

    private int arr[];   // Array of size n to store actual content to be stored in queue
    private int front[];   // Array of size k to store indexes of front elements of queue
    private int rear[];   // Array of size k to store indexes of rear elements of queue
    private int next[];  // Array of size n to store next entry in all queues and free list
    int n, k;
    int free; // To store beginning index of free list

    public ImplementKQueuesInSingleArray(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        // Initialize all queues as empty
        for (int i = 0; i < k; i++)
            front[i] = -1;
        // Initialize all spaces as free
        free = 0;
        for (int i=0; i<n-1; i++)
            next[i] = i+1;
        next[n-1] = -1;  // -1 is used to indicate end of free list
    }

    boolean isFull()   {  return (free == -1);  }

    boolean isEmpty(int qn)  {  return (front[qn] == -1); }

    void enqueue(int item, int qn)
    {
        // Overflow check
        if (isFull())
        {
            System.out.println("Overflow ");
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

    int dequeue(int qn)
    {
        // Underflow checkSAS
        if (isEmpty(qn))
        {
            System.out.println(" Queue Underflow");
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

    public static void main(String[] args) {
        ImplementKQueuesInSingleArray queues =new ImplementKQueuesInSingleArray(3,10);
        queues.enqueue(10 ,1);
        queues.enqueue(20 ,2);
        queues.enqueue(30 ,1);
        queues.enqueue(40 ,2);
        queues.enqueue(50 ,1);
        queues.enqueue(60 ,1);
        queues.enqueue(70 ,1);
        queues.enqueue(80 ,1);
        queues.enqueue(90 ,3);
        queues.enqueue(100 ,3);
    }
}

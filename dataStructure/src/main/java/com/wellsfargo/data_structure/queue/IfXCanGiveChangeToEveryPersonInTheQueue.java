package com.wellsfargo.data_structure.queue;

public class IfXCanGiveChangeToEveryPersonInTheQueue {

    private int[] inputArray;

    public IfXCanGiveChangeToEveryPersonInTheQueue(int[] inputArray) {
        this.inputArray = inputArray;
    }

    boolean isChangeable() {

        int fiveCount = 0;
        int tenCount = 0;

        // Serve the customer
        // in order
        for (int i = 0; i < inputArray.length - 1; i++) {

            // Increase the number
            // of 5$ note by one
            if (inputArray[i] == 5)
                fiveCount++;
            else if (inputArray[i] == 10) {

                // decrease the number
                // of note 5$ and
                // increase 10$ note by one
                if (fiveCount > 0) {
                    fiveCount--;
                    tenCount++;
                } else
                    return false;
            } else {

                // decrease 5$ and
                // 10$ note by one
                if (fiveCount > 0 &&
                        tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                }

                // decrease 5$
                // note by three
                else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int a[] = {5, 5, 5, 10, 20};
        IfXCanGiveChangeToEveryPersonInTheQueue change =new IfXCanGiveChangeToEveryPersonInTheQueue(a);
        System.out.println(change.isChangeable());
    }
}
